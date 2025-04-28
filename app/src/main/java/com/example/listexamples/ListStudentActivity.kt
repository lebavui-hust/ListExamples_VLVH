package com.example.listexamples

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val students = mutableListOf<StudentModel>()
        for (i in 1..28) {
            students.add(StudentModel(
                resources.getIdentifier("thumb$i", "drawable", packageName),
                "Student $i",
                "MSSV $i"
            ))
        }

        val adapter = StudentAdapter(students)

        val listStudent = findViewById<ListView>(R.id.list_students)
        listStudent.adapter = adapter


    }
}