package com.marvel.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.adapters.CharactersAdapter
import com.marvel.databinding.ActivityMainBinding
import com.marvel.viewmodel.CharactersViewModel

class MainActivity : BaseActivity() {
    lateinit var mainBinding: ActivityMainBinding
    lateinit var charactersAdapter: CharactersAdapter
    lateinit var viewModel: CharactersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        setupViews()
    }

    override fun setupViews() {
        mainBinding.charactersListview.layoutManager = LinearLayoutManager(this)
        showLoader()
        viewModel = ViewModelProvider(this)[CharactersViewModel::class.java]
        viewModel.resultsListObserver.observe(this) { resultsList ->
            if (resultsList != null && resultsList.size > 0) {
                charactersAdapter = CharactersAdapter(resultsList)
                mainBinding.charactersListview.adapter = charactersAdapter
                hideLoader()
            } else {
                hideLoader()
                mainBinding.txNoResult.visibility = View.VISIBLE
            }
        }
        viewModel.makeApiCall()
    }
}