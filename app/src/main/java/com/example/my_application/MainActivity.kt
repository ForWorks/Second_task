package com.example.my_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_application.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.FrameLayout, FirstFragment.newInstance())
                .commit()
        }
    }
}