package com.example.myapplicationlv5

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplicationlv5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setUpUi()
        this.loadSounds()
    }

    private fun setUpUi() {
        binding.image1.setOnClickListener({ playSound(R.raw.airplane) })
        binding.image2.setOnClickListener({ playSound(R.raw.bell) })
        binding.image3.setOnClickListener({ playSound(R.raw.rain) })
    }

    private fun loadSounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        } else {
            this.mSoundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
        }
        this.mSoundPool.setOnLoadCompleteListener { _, _, _ ->
            mLoaded = true
        }

        this.mSoundMap[R.raw.airplane] =
            this.mSoundPool.load(this, R.raw.airplane, 1)

        this.mSoundMap[R.raw.bell] =
            this.mSoundPool.load(this, R.raw.bell, 1)

        this.mSoundMap[R.raw.rain] =
            this.mSoundPool.load(this, R.raw.rain, 1)
    }

    override fun onClick(v: View) {
        if (this.mLoaded == false)
            return when (v.getId()) {
                R.id.image1 -> playSound(R.raw.airplane)
                R.id.image2 -> playSound(R.raw.bell)
                R.id.image3 -> playSound(R.raw.rain)
                else -> playSound(R.raw.rain)
            }
    }

    fun playSound(selectedSound: Int) {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(
            soundID,
            1f,
            1f,
            1,
            0,
            1f
        )
    }
}