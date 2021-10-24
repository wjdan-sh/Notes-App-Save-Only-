package com.example.notesappsaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var RC: RecyclerView
    private lateinit var ed: EditText
    private lateinit var btn: Button
    private lateinit var masseges: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RC = findViewById(R.id.rv)
        masseges = ArrayList()


        ed = findViewById(R.id.ed)
        btn = findViewById(R.id.btn)

        RC.adapter = RVAdapter(masseges)
        RC.layoutManager = LinearLayoutManager(this)

        btn.setOnClickListener {

            val masseg = ed.text.toString()

            var dbh = DBHelper(applicationContext)
            var status = dbh.save(masseg)
            Toast.makeText(this, "data saved! " + status , Toast.LENGTH_SHORT).show()
        }
    }
}