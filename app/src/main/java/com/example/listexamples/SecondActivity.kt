package com.example.listexamples

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val items = mutableListOf<String>()
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, items)
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = adapter

        val editNumber = findViewById<EditText>(R.id.edit_number)
        findViewById<Button>(R.id.button_show).setOnClickListener {
            val number = editNumber.text.toString().toInt()
            items.clear()
            for (i in 1..number)
                items.add("$i")
            adapter.notifyDataSetChanged()
        }
    }
}