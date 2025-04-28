package com.example.listexamples

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_image)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Chuan bi du lieu
        val images = mutableListOf<Int>()
        for (i in 1..28) {
            images.add(resources.getIdentifier("thumb$i", "drawable", packageName))
        }

        // 2. Tao adapter
        val width = resources.displayMetrics.widthPixels
        val adapter = ImageAdapter(images, width / 3)

        // 3. Thiet lap adapter cho GridView
        val gridImages = findViewById<GridView>(R.id.grid_images)
        gridImages.adapter = adapter

    }
}