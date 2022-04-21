package com.example.dotango

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnHero = view.findViewById<ImageView>(R.id.heroimage)
        btnHero.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_heropage)
        }
        val btnItems = view.findViewById<ImageView>(R.id.itemsimage)
        btnItems.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_itempage)
        }
        return view
    }


}