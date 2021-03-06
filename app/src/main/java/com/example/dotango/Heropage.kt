package com.example.dotango

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonIOException
import java.io.IOException
import java.nio.charset.Charset

class Heropage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_heropage, container, false)
        try{

            val json = getJsonString("heroes.json")!!
            val heroes = Gson().fromJson(json, Heroes::class.java)

            val rcycview = view.findViewById<RecyclerView>(R.id.rcycview)

            rcycview.layoutManager = GridLayoutManager(view.context, 3)
            val itemAdapter = recyclerAdapter(view.context, heroes)
            rcycview.adapter = itemAdapter

        }catch (e : JsonIOException){
            e.printStackTrace()
        }

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