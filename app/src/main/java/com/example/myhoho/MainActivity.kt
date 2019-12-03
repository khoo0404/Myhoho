package com.example.myhoho

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //module-level variable
    private var like: Int = 0
    private var dislike: Int = 0

    //Declare an instance of the SharedPref
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the shared Pref
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        TextViewLike.text = like.toString()
        TextViewDislike.text = dislike.toString()
        imageViewLike.setOnClickListener() {
            like++
            TextViewLike.text = like.toString()
        }
        imageViewDislike.setOnClickListener() {
            dislike++;
            TextViewDislike.text = dislike.toString()
        }

        Log.d("MainActivity", "OnCreate")

    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")
        //Retrieve the Shared Pref
        like = sharedPreferences.getInt(getString(R.string.like), 0)
        dislike = sharedPreferences.getInt(getString(R.string.dislike), 0)

        TextViewLike.text = like.toString()
        TextViewDislike.text = dislike.toString()
        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity", "OnStop")
        super.onStop()
    }

    override fun onPause() {
        Log.d("MainActivity", "OnPause")
        with(sharedPreferences.edit()) {
            putInt(getString(R.string.like), like)
            putInt(getString(R.string.dislike), dislike)
            apply()
            // or commit()

        }
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "OnDestroy")

            super.onDestroy()
        }

    }


