package com.example.mylv3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mylv3.R
import com.example.mylv3.databinding.NewBirdBinding
import com.example.mylv3.di.BirdRepositoryFactory
import com.example.mylv3.getDate
import com.example.mylv3.model.Bird
import com.example.mylv3.model.BirdPhoto

class NewBirdFragment: Fragment() {

    private lateinit var  binding: NewBirdBinding
    private val birdRepository = BirdRepositoryFactory.taskRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewBirdBinding.inflate(
            inflater, container, false
        )
        binding.bSaveTask.setOnClickListener{saveTask()}
        return binding.root
    }

    private fun saveTask() {

        val title = binding.etTaskLocationInput.text.toString()


        val photo = when(binding.rgPriorityInput.checkedRadioButtonId){
            R.id.rb_priority_high -> BirdPhoto.Roda
            R.id.rb_priority_medium -> BirdPhoto.Papiga
            R.id.rb_priority_low -> BirdPhoto.Slavuj
            else -> BirdPhoto.Slavuj
        }
        val dateAdded = binding.dpDateAddedInput.getDate()

        birdRepository.save(Bird(0, title, "contents", photo, dateAdded))

        Toast.makeText(context, "New bird added", Toast.LENGTH_SHORT).show()

        val action = NewBirdFragmentDirections.actionNewBirdFragmentToBirdListFragment()
        findNavController().navigate(action)
    }
}