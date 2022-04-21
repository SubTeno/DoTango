package com.example.dotango

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.NullPointerException


class itemdetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_itemdetail, container, false)


            //Getting
            val itemName = arguments?.getString("itemName")
            val itemDesc = arguments?.getStringArrayList("itemDesc")
            val itemCost = arguments?.getInt("itemCost")
            val itemImg = arguments?.getString("itemImg")
            Log.d("test", "$itemImg    $itemName     $itemCost",)
            //Assigning
            view.findViewById<TextView>(R.id.itemTitle).text = itemName
            itemDesc?.forEach {
                view.findViewById<TextView>(R.id.itemDesc).append(it + "\n")
            }
            Picasso.get().load("https://api.opendota.com${itemImg}").into(view.findViewById<ImageView>(R.id.itemImg))
            view.findViewById<TextView>(R.id.itemDesc).append("\n Cost : ${itemCost.toString()}")


        return view
    }
}