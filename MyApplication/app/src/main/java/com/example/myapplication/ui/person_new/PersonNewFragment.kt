package com.example.myapplication.ui.person_new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPersonNewBinding
import com.example.myapplication.di.PersonRepositoryFactory
import com.example.myapplication.model.Person

class PersonNewFragment : Fragment() {

    private lateinit var binding: FragmentPersonNewBinding

    private val taskRepository = PersonRepositoryFactory.taskRepository //TaskRepositoryFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonNewBinding.inflate(inflater, container, false)

        binding.btnAddNewPerson.setOnClickListener{saveTask()}

        return binding.root
    }

    private fun saveTask() {

//        val title = binding.etTaskTitleInput.text.toString()
//        val contents = binding.etTaskContentsInput.text.toString()
//
//        val priority = when(binding.rgPriorityInput.checkedRadioButtonId){
//            R.id.rb_priority_high -> TaskPriority.High
//            R.id.rb_priority_medium -> TaskPriority.Medium
//            R.id.rb_priority_low -> TaskPriority.Low
//            else -> TaskPriority.Low
//        }
//
//        taskRepository.save(Task(0, title, contents, priority))

        var q = mutableListOf<String>("quote1", "quote2")

        val person = Person(55, "tm", "1998", q)


        Toast.makeText(context, getString(R.string.save_person), Toast.LENGTH_SHORT).show()

        val action = PersonNewFragmentDirections.actionPersonNewFragmentToPersonListFragment()
            //NewTaskFragmentDirections.actionNewTaskFragmentToTaskListFragment()

        taskRepository.save(person)
        findNavController().navigate(action)
    }

    companion object {
        fun create(): Fragment {
            return PersonNewFragment()
        }
    }
}