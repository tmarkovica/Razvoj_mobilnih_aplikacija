package hr.mosaicapps.animalcounter.ui.animalcounting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import hr.mosaicapps.animalcounter.R
import hr.mosaicapps.animalcounter.databinding.ActivityAnimalCounterBinding
import hr.mosaicapps.animalcounter.ui.animalcounting.viewmodels.AnimalCounterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalCounterActivity : AppCompatActivity() {
    private val viewModel by viewModel<AnimalCounterViewModel>()
    private lateinit var binding: ActivityAnimalCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnimalCounterBinding.inflate(layoutInflater).also {
            it.bCatsSeen.setOnClickListener { countDogsClick() }
            it.bDogsSeen.setOnClickListener { viewModel.seeDog() }
        }
        //setContentView(binding.root)

//        viewModel.dogsSeen.observe(this, { binding.tvDogsSeen.text = it.toString()})
//        viewModel.catsSeen.observe(this, { binding.tvCatsSeen.text = it.toString()})
//        viewModel.animalsSeen.observe(this, { binding.tvAnimalsSeen.text = it.toString()})

        DataBindingUtil.setContentView<ActivityAnimalCounterBinding>(
            this, R.layout.activity_animal_counter
        ).apply {
            this.setLifecycleOwner(this@AnimalCounterActivity)
            this.viewmodel = viewModel
        }

        viewModel.counter.observe(this, Observer {
            Log.d("TAG", "Data observed.")
        })
    }

    private fun countDogsClick() {
        Log.d("TAG", "is calling?")
        viewModel.seeCat()
    }
}