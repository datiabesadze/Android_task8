package com.example.note

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var addNoteEditText: EditText
    private lateinit var addNoteButton: Button
    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNoteEditText = findViewById(R.id.note_adder_edittext)
        addNoteButton= findViewById(R.id.note_adder_button)
        addNoteButton.setOnClickListener {
            savePrefs()
        }

        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

    }

    private fun savePrefs() {
        var sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        var notes: Set<String> = sharedPreferences.getStringSet("NOTE_KEY", setOf("whatup", "dood")) as Set<String>
        notes = notes + addNoteEditText.text.toString()

        editor.apply {
            putStringSet("NOTE_KEY", notes)
        }.apply()

        Toast.makeText(this, "saved data: ${notes}", Toast.LENGTH_LONG).show()
    }

}