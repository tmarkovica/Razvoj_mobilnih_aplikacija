package hr.mosaicapps.animalcounter.ui.animalcounting.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import hr.mosaicapps.animalcounter.model.AnimalCounter
import hr.mosaicapps.animalcounter.model.AnimalCounterAlternative

class AnimalCounterViewModel(private val animalCounter: AnimalCounter) : ViewModel() {

    //private
    val counter = MutableLiveData<AnimalCounter>(AnimalCounter())

    val dogsSeen = Transformations.map(counter) {it.dogsSeen}
    val catsSeen = Transformations.map(counter) {it.catsSeen}
    val animalsSeen = Transformations.map(counter){it.animalsSeen}

    fun seeDog() {
        var count = counter.value?.seeDog()!!
        Log.d("TAG", "Dogs counter ${count}")
        //return count
    }
    fun seeCat() {
        var count = counter.value?.seeCat()!!
        Log.d("TAG", "Cats seen: " + count.toString())
        //return count
    }

//    private val _dogsSeen = MutableLiveData(animalCounter.dogsSeen)
//    val dogsSeen: LiveData<Int> = _dogsSeen
//
//    private val _catsSeen = MutableLiveData(animalCounter.catsSeen)
//    val catsSeen: LiveData<Int> = _catsSeen
//
//    private val _animalsSeen = MutableLiveData(animalCounter.animalsSeen)
//    val animalsSeen: LiveData<Int> = _animalsSeen
//
//    fun seeDog() {
//        animalCounter.seeDog()
//        _dogsSeen.postValue(animalCounter.dogsSeen)
//        _animalsSeen.postValue(animalCounter.animalsSeen)
//    }
//
//    fun seeCat() {
//        animalCounter.seeCat()
//        _catsSeen.postValue(animalCounter.catsSeen)
//        _animalsSeen.postValue(animalCounter.animalsSeen)
//    }
}

