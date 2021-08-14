package com.veyselakbalik.btkbesinlerkitabi.service

import com.veyselakbalik.btkbesinlerkitabi.model.Besin
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface BesinAPI {

//    https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
//    BASE URL https://raw.githubusercontent.com/
//    atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json


    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin() : Single<List<Besin>>

}