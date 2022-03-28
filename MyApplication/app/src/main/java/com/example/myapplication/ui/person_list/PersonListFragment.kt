package com.example.myapplication.ui.person_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentPersonListBinding
import com.example.myapplication.di.PersonRepositoryFactory

class PersonListFragment : Fragment(), PersonSelectedListener {

    private lateinit var binding: FragmentPersonListBinding

    private lateinit var adapter: PersonAdapter
    private val peopleRepository = PersonRepositoryFactory.peopleRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonListBinding.inflate(
            inflater, container, false
        )
        binding.fabAddPerson.setOnClickListener({ showNewPersonFragment()})

        setupRecyclerView()

        return binding.root
    }

    private fun showNewPersonFragment() {
        val action = PersonListFragmentDirections.actionPersonListFragmentToPersonNewFragment()

        findNavController().navigate(action)
    }

    private fun setupRecyclerView() {
        binding.personListRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = PersonAdapter()
        adapter.personSelectedListener = this
        binding.personListRv.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateData()
        Log.d("TAG", "Resumed")
    }

    private fun updateData() {
        adapter.setPeople(peopleRepository.getAllTasks())
    }

//    companion object {
//        fun create(): Fragment {
//            return PersonListFragment()
//        }
//    }

    override fun personSelected(id: Long?) {
        val action =
            PersonListFragmentDirections.actionPersonListFragmentToPersonDetailsFragment(id ?: -1)
        findNavController().navigate(action)
    }
}