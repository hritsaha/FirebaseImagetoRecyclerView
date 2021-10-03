package com.example.rview3

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val n = intent.getStringExtra("IT")
//        val tv : TextView = findViewById(R.id.secondTxt)
        val iv : ImageView = findViewById(R.id.secondImage)
        Picasso.get().load(n).into(iv)

    }
}