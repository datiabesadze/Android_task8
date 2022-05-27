package com.example.note

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var noteTitles: Set<String>
    private var titles = arrayOf("first title", "second title", "third title", "fourth title", "fifth title")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.noteTitle.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var noteTitle: TextView
        var noteEdit: Button

        init {
            noteTitle = itemView.findViewById(R.id.note_title)
            noteEdit = itemView.findViewById(R.id.edit_button)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(
                    itemView.context,
                    "here: ${titles[position]}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}