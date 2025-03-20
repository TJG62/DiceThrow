package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel: ViewModel() {

    private var dieSides: Int = 6

    private val currentIndex: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getCurrentIndex(): LiveData<Int>{
        return currentIndex
    }

    fun setCurrentIndex(index: Int){
        currentIndex.value = index
    }
    fun rollDie(){
        setCurrentIndex(Random.nextInt(dieSides) + 1)
    }
}