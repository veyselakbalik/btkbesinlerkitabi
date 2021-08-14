package com.veyselakbalik.btkbesinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veyselakbalik.btkbesinlerkitabi.model.Besin

class BesinListesiViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()


    fun refreshData(){
        val muz = Besin("Muz","100","10","5","1","www.test.com")
        val cilek = Besin("Cilek","250","15","2","0","www.test.com")
        val elma = Besin("Elma","325","5","10","2","www.test.com")

        val besinListesi = arrayListOf<Besin>(muz,cilek,elma)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }
}