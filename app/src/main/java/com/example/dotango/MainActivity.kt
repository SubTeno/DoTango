package com.example.dotango

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.dotango.databinding.MainactivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}