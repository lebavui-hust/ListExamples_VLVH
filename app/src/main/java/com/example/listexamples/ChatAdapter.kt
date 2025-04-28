package com.example.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(val messages: List<ChatModel>) : BaseAdapter() {
    override fun getCount() = messages.size

    override fun getItem(position: Int) = messages[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getViewTypeCount() = 2

    override fun getItemViewType(position: Int)
        = if (messages[position].username == "me") 1 else 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val itemView: View
        if (convertView == null) {
            if (getItemViewType(position) == 0)
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_left, null)
            else
                itemView = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_right, null)
        } else
            itemView = convertView

        val imageAvatar = itemView.findViewById<ImageView>(R.id.image_avatar)
        val textMessage = itemView.findViewById<TextView>(R.id.text_message)

        val message = messages[position]
        imageAvatar.setImageResource(message.avatarId)
        textMessage.text = message.message

        return itemView
    }
}