package com.example.myapplicationlv4

import android.app.Application
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationlv4.databinding.ActivityMainBinding
import com.example.myapplicationlv4.di.sharedPrefers
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel: MainViewModel by lazy {
//        ViewModelProvider(this).get(MainViewModel::class.java)
//    }

    private val viewModel: MainViewModel by viewModel() // viewModel(qualifier .......)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bIncrementCount.setOnClickListener({ incrementCount() })
        //binding.tvCount.text = viewModel.count.toString()

        viewModel.count.observe(this) { count: Int -> updateCountDisplay(count) } // ali kod fragmenta salji lifecycleowner

        // košarkaška utakmica
        binding.bTeam1score1.setOnClickListener({ viewModel.team1Scored(1) })
        binding.bTeam1score2.setOnClickListener({ viewModel.team1Scored(2) })
        binding.bTeam1score3.setOnClickListener({ viewModel.team1Scored(3) })

        binding.bTeam2score1.setOnClickListener({ viewModel.team2Scored(1) })
        binding.bTeam2score2.setOnClickListener({ viewModel.team2Scored(2) })
        binding.bTeam2score3.setOnClickListener({ viewModel.team2Scored(3) })

        binding.bResetScore.setOnClickListener({ viewModel.resetScore() })
        binding.bSaveScore.setOnClickListener({
            if (viewModel.saveScore())
                Toast.makeText(this, "Score Saved", Toast.LENGTH_SHORT).show()
        })

        viewModel.team1Score.observe(this) { updateTeam1Score(it) }
        viewModel.team2Score.observe(this) { updateTeam2Score(it) }

        setContentView(binding.root)
    }

    private fun updateTeam2Score(it: Int?) {
        binding.tvTeam2.text = it.toString()

        if (it!! > 30)
            binding.tvTeam2.setBackgroundColor(resources.getColor(R.color.green))
    }

    private fun updateTeam1Score(it: Int?) {
        binding.tvTeam1.text = it.toString()

        if (it!! > 30)
            binding.tvTeam1.setBackgroundColor(resources.getColor(R.color.green))
    }


    private fun incrementCount() {
        viewModel.incrementCount()
        //binding.tvCount.text = viewModel.count.toString()
    }

    private fun updateCountDisplay(count: Int) {
        binding.tvCount.text = count.toString()
    }
}
