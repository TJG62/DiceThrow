package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel: ViewModel() {
    private val currentIndex: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    fun getCurrentIndex(): LiveData<Int>{
        return currentIndex
    }

    fun setCurrentIndex(index: Int){
        currentIndex.value = index
    }
}