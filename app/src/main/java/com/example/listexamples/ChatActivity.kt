package com.example.listexamples

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val messages = mutableListOf<ChatModel>()
        messages.add(ChatModel("me", R.drawable.thumb1, "Hello"))
        messages.add(ChatModel("user", R.drawable.thumb2, "Hi"))
        messages.add(ChatModel("me", R.drawable.thumb1, "How are you?"))
        messages.add(ChatModel("user", R.drawable.thumb2, "I'm fine. Thanks"))

        val adapter = ChatAdapter(messages)
        val listMessages = findViewById<ListView>(R.id.list_messages)
        listMessages.adapter = adapter
    }
}