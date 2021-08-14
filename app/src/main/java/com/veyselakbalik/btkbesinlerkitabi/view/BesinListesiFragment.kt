package com.veyselakbalik.btkbesinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.veyselakbalik.btkbesinlerkitabi.R
import com.veyselakbalik.btkbesinlerkitabi.adapter.BesinRecyclerAdapter
import com.veyselakbalik.btkbesinlerkitabi.viewmodel.BesinListesiViewModel
import kotlinx.android.synthetic.main.fragment_besin_listesi.*

class BesinListesiFragment : Fragment() {

    private lateinit var viewModel : BesinListesiViewModel
    private val recyclerBesinAdapter = BesinRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[BesinListesiViewModel::class.java]
        viewModel.refreshData()

        besinListRecycler.layoutManager = LinearLayoutManager(context)
        besinListRecycler.adapter = recyclerBesinAdapter

        observeLiveData()
    }

    fun observeLiveData(){

        viewModel.besinler.observe(viewLifecycleOwner, Observer {
            it?.let {
                besinListRecycler.visibility = View.VISIBLE
                recyclerBesinAdapter.besinListesiniGuncelle(it)
            }
        })
        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    besinHataMesaji.visibility = View.VISIBLE
                    besinListRecycler.visibility = View.GONE

                }else {
                    besinHataMesaji.visibility = View.GONE
                }
            }
        })
        viewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    besinListRecycler.visibility = View.GONE
                    besinHataMesaji.visibility = View.GONE
                    besinYukleniyor.visibility = View.VISIBLE
                }else {
                    besinYukleniyor.visibility = View.GONE
                }
            }
        })

    }

}