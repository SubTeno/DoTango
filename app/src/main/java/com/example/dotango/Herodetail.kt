package com.example.dotango

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class Herodetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_herodetail, container, false)
        //Hero Name
        val heroName = arguments?.get("heroName").toString()
        //Hero Image Resource
        val heroImgRes = arguments?.get("heroImgRes") as Int
        //Parsing jsons to JSONObject
        val heroLore = JSONObject(getJsonString("heroLore.json"))
        val heroAbilities = JSONObject(getJsonString("heroAbilities.json"))
        val abilities = JSONObject(getJsonString("abilities.json"))


        val abilityArray = Gson().fromJson(heroAbilities.getJSONObject(heroName).getJSONArray("abilities").toString(), Array<String>::class.java)
        abilityArray.forEach {
            val abilityCard = inflater.inflate(R.layout.ability_card, container, false)
            val ability = abilities.getJSONObject(it)

            try {
                // Populating data into view
                abilityCard.findViewById<TextView>(R.id.abilityTitle).text =
                    ability.getString("dname")
                abilityCard.findViewById<TextView>(R.id.abilityDesc).text =
                    ability.getString("desc")
                Picasso.get().load("https://api.opendota.com${ability.getString("img")}")
                    .into(abilityCard.findViewById<ImageView>(R.id.abilityImage));
                // Inserting view into fragment
                view.findViewById<LinearLayout>(R.id.linearHeroDetail).addView(abilityCard)
            }catch(e:JSONException) {

            }

            }





        //getting lore and parse it into textview
        view.findViewById<TextView>(R.id.lore).text = heroLore.getString(heroName.replace("npc_dota_hero_", ""))

        view.findViewById<ImageView>(R.id.heroImageDetail).setImageResource(heroImgRes)

        return view
    }

    private fun getJsonString(fileName: String): String?{
        val json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val jsonFile = context?.assets?.open(fileName)
            val size = jsonFile?.available()
            val buffer = size?.let { ByteArray(it) }
            jsonFile?.read(buffer)
            jsonFile?.close()
            json = buffer?.let { String(it, charset) }

        }catch(ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }

}