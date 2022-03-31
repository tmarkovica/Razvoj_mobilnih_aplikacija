package com.example.mylv3.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylv3.R
import com.example.mylv3.databinding.ItemBirdBinding
import com.example.mylv3.getPhotoResource
import com.example.mylv3.model.Bird

class BirdAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private val tasks = mutableListOf<Bird>()
    var onTaskSelectedListener: OnBirdEventListener? = null

    fun setTasks(tasks: List<Bird>) {
        this.tasks.clear()
        this.tasks.addAll(tasks)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bird, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
        onTaskSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onTaskSelected(task.id) }
            holder.itemView.setOnLongClickListener { listener.onTaskLongPress(task) }
        }
    }

    override fun getItemCount(): Int = tasks.count()
}

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(task: Bird) {
        val binding = ItemBirdBinding.bind(itemView)
        binding.itemTaskTitle.text = task.location

        val dateStr: String = task.dateAdded.date.toString() + "." + task.dateAdded.month + "." +  task.dateAdded.year + "."
        binding.itemTaskDate.text = dateStr

        binding.itemTaskPriority.setBackgroundResource(
            binding.itemTaskPriority.context.resources.getPhotoResource(task.priority)
        )
    }
}