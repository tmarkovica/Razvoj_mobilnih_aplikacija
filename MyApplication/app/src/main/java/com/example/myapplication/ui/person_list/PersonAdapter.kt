package com.example.myapplication.ui.person_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemPersonBinding
import com.example.myapplication.model.Person

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {

    private val people = mutableListOf<Person>()
    var personSelectedListener: PersonSelectedListener? = null

    fun setPeople(people: List<Person>) {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.bind(person)
        personSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.personSelected(person.id) }
        }
    }

    override fun getItemCount(): Int = people.count()
}

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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