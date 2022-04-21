package com.example.dotango

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class Itempage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_itempage, container, false)
        val jsonObject = getJsonString("items.json")!!
        val items = Gson().fromJson(jsonObject, Items::class.java)

        val rcycview = view.findViewById<RecyclerView>(R.id.rcycviewItem)

        rcycview.layoutManager = GridLayoutManager(view.context, 3)
        val itemAdapter = rcycItem(view.context, items)
        rcycview.adapter = itemAdapter

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