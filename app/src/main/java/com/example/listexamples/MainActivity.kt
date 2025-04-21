package com.example.listexamples

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Chuan bi du lieu
        val items = mutableListOf<String>()
        repeat(50) { items.add("Item $it") }

        // 2. Tao adapter
        // a. Su dung giao dien mac dinh
//        val adapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            items
//        )
        // b. Su dung giao dien tuy chinh
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.layout_simple_item,
            R.id.text_content,
            items
        )

        // 3. Thiet lap adapter cho danh sach
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = adapter

        // 4. Xu ly su kien chon phan tu
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.v("TAG", "${items[position]} is clicked")
            }
        }

        // 5. Xu ly khi du lieu thay doi
        findViewById<Button>(R.id.button_add).setOnClickListener {
            items.add(0, "New Item")
            adapter.notifyDataSetChanged()
        }
        findViewById<Button>(R.id.button_remove).setOnClickListener {
            items.removeAt(0)
            adapter.notifyDataSetChanged()
        }
        findViewById<Button>(R.id.button_update).setOnClickListener {
            items[0] = "Updated Item"
            adapter.notifyDataSetChanged()
        }
    }
}