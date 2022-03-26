package com.example.myapplication.ui.person_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemPersonBinding
import com.example.myapplication.model.Person

class PersonAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    val people = mutableListOf<Person>()
    var onTaskSelectedListener: PersonSelectedListener? = null

    fun setTasks(tasks: List<Person>) {
        this.people.clear()
        this.people.addAll(tasks)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = people[position]
        holder.bind(task)
        onTaskSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onTaskSelected(task.id) }
        }
    }

    override fun getItemCount(): Int = people.count()
}

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(person: Person) {

        val binding = ItemPersonBinding.bind(itemView)
        binding.itemPersonId.text = person.id.toString()
        binding.itemPersonName.text = person.name
        binding.itemPersonBirthDate.text = person.birthDate
        binding.itemPersonQuotes.text = person.quotes.toString()

//        val binding = ItemTaskBinding.bind(itemView)
//        binding.itemTaskTitle.text = task.name
//        binding.itemTaskContent.text = task.birthDate
//        binding.itemTaskPriority.setBackgroundResource(
//            binding.itemTaskPriority.context.resources.getColorResource(task.priority)
//        )
    }
}