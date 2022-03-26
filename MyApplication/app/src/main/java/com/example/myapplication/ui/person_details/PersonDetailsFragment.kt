package com.example.myapplication.ui.person_details

import android.app.Person
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentPersonDetailsBinding
import com.example.myapplication.di.PersonRepositoryFactory

class PersonDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPersonDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    private val taskRepository = PersonRepositoryFactory.taskRepository
    private val args: PersonDetailsFragmentArgs by navArgs() // TaskDetailsFragmentArgs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task = taskRepository.getTaskById(args.personid)
        display(task)
    }

    private fun display(person: com.example.myapplication.model.Person?) {
        person?.let {
            binding.apply {
                binding.itemPersonId.text = person.id.toString()
                binding.itemPersonName.text = person.name
                binding.itemPersonBirthDate.text = person.birthDate
                binding.itemPersonQuotes.text = person.quotes.toString()
//                clTaskDetailsRoot.setBackgroundResource(resources.getColorResource(task.priority))
//                tvTaskDetailsTitle.text = task.title
//                tvTaskDetailsContents.text = task.content
            }
        }
    }

    companion object {
        val Tag = "TasksDetails"
        val TaskIdKey = "TaskId"

        fun create(id: Long): Fragment {
            val fragment = PersonDetailsFragment() //TaskDetailsFragmentTaskDetailsFragment
            return fragment
        }
    }
}