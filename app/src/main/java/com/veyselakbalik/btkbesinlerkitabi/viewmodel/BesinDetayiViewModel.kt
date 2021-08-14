package com.veyselakbalik.btkbesinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veyselakbalik.btkbesinlerkitabi.model.Besin

class BesinDetayiViewModel : ViewModel() {
    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl() {
        val muz = Besin("Muz","100","10","5","1","www.test.com")
        besinLiveData.value = muz
    }

}