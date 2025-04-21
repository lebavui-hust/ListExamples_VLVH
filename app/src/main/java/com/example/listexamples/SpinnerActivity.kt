package com.example.listexamples

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        // 1. Chuan bi du lieu
        val exchangeRates = listOf(
            ExchangeRate("USD", 24380.0), // Đô la Mỹ
            ExchangeRate("EUR", 26450.0), // Euro
            ExchangeRate("JPY", 167.0),    // Yên Nhật
            ExchangeRate("GBP", 30890.0), // Bảng Anh
            ExchangeRate("AUD", 15900.0), // Đô la Úc
            ExchangeRate("CAD", 17950.0), // Đô la Canada
            ExchangeRate("SGD", 18100.0), // Đô la Singapore
            ExchangeRate("KRW", 18.5),    // Won Hàn Quốc
            ExchangeRate("CNY", 3400.0)   // Nhân dân tệ
        )

        val currencies = exchangeRates.map { it.currency }
        val rates = exchangeRates.map { it.rate }

        // 2. Tao adapter
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            currencies)

        // 3. Thiet lap adapter cho spinner
        val spinner = findViewById<Spinner>(R.id.spinner_currencies)
        spinner.adapter = adapter

        val editFrom = findViewById<EditText>(R.id.edit_from)
        val textResult = findViewById<TextView>(R.id.text_result)

        findViewById<Button>(R.id.button_convert).setOnClickListener {
            val fromValue = editFrom.text.toString().toInt()
            val rate = rates[spinner.selectedItemPosition]
            val result = fromValue / rate
            textResult.text = "Result: $result"
        }

        // 4. Xu ly su kien
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Log.v("TAG", "${items[position]} is selected")
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//        }
    }
}