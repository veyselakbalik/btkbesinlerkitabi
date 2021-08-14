package com.veyselakbalik.btkbesinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.veyselakbalik.btkbesinlerkitabi.R
import com.veyselakbalik.btkbesinlerkitabi.viewmodel.BesinDetayiViewModel
import kotlinx.android.synthetic.main.fragment_besin_detayi.*

class BesinDetayiFragment : Fragment() {

    private lateinit var viewModel : BesinDetayiViewModel
    private var besinId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[BesinDetayiViewModel::class.java]
        viewModel.roomVerisiniAl()



        arguments?.let{
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }

        observeLiveData()
    }

    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                besinIsim.text = it.besinIsim
                besinKalori.text = it.besinKalori
                besinKarbonhidrat.text = it.besinKarbonhidrat
                besinProtein.text = it.besinProtein
                besinYag.text = it.besinYag
            }
        })
    }
}