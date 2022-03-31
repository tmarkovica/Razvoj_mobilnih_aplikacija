package com.example.mylv3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylv3.databinding.BirdListBinding
import com.example.mylv3.di.BirdRepositoryFactory
import com.example.mylv3.model.Bird

class BirdListFragment: Fragment(), OnBirdEventListener {

    private lateinit var binding: BirdListBinding
    private lateinit var adapter: BirdAdapter
    private val taskRepository = BirdRepositoryFactory.taskRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //binding = BirdListBinding.inflate(layoutInflater)
        binding = BirdListBinding.inflate(
            inflater, container, false
        )

        setupRecyclerView()
        binding.fabAddNote.setOnClickListener { showCreateNewTaskFragment() }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.taskListRvTasks.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = BirdAdapter()
        adapter.onTaskSelectedListener = this
        binding.taskListRvTasks.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setTasks(taskRepository.getAllTasks())
    }

    override fun onTaskSelected(id: Long?) {
//        val action =
//            TaskListFragmentDirections.actionTaskListFragmentToTaskDetailsFragment(id ?: -1)
//        findNavController().navigate(action)
    }

    override fun onTaskLongPress(task: Bird?): Boolean {
//        task?.let { it ->
//            taskRepository.delete(it)
//            adapter.setTasks(taskRepository.getAllTasks())
//        }
        return true
    }

    private fun showCreateNewTaskFragment() {
        val action = BirdListFragmentDirections.actionBirdListFragmentToNewBirdFragment()
        findNavController().navigate(action)
    }
}