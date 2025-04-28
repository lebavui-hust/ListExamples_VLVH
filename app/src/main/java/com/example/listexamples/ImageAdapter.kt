package com.example.listexamples

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(val images: List<Int>, val imageSize: Int): BaseAdapter() {
    override fun getCount() = images.size

    override fun getItem(position: Int) = images[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val imageView = ImageView(parent?.context)
        imageView.layoutParams = ViewGroup.LayoutParams(imageSize, imageSize)
        imageView.setImageResource(images[position])
        imageView.setPadding(4, 4, 4, 4)
        return imageView
    }
}