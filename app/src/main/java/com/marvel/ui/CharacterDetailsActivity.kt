package com.marvel.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvel.R
import com.marvel.adapters.CharactersAdapter
import com.marvel.adapters.all.AllCategories
import com.marvel.adapters.all.AllCategoriesAdapter
import com.marvel.config.Constants
import com.marvel.databinding.ActivityCharacterDetailsBinding
import com.marvel.viewmodel.CharacterDetailsViewModel

class CharacterDetailsActivity : BaseActivity() {
    lateinit var activityCharacterDetailsBinding: ActivityCharacterDetailsBinding
    lateinit var viewModel: CharacterDetailsViewModel
    lateinit var characterId: String
    lateinit var characterName: String
    lateinit var categoriesAr: ArrayList<AllCategories>
    lateinit var allCategoriesAdapter: AllCategoriesAdapter
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCharacterDetailsBinding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        val view = activityCharacterDetailsBinding.root
        mContext = view.context
        setContentView(view)
        setupViews()
    }

    override fun setupViews() {
        val bundle = intent.extras
        if (bundle != null) {
            characterId = bundle.getString(Constants.CharacterID, "")
            characterName = bundle.getString(Constants.CharacterName, "")
        }
        activityCharacterDetailsBinding.toolbarDetails.toolbarTitle.text = characterName
        activityCharacterDetailsBinding.txCharacterId.text = mContext.getString(R.string.charater_id, characterId)
        activityCharacterDetailsBinding.toolbarDetails.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        categoriesAr = ArrayList()
        viewModel = CharacterDetailsViewModel()
        viewModel.setCharacterID(characterId)

        showLoader()
        viewModel.comicsListObserve.observe(this, Observer { comicsList ->
            if (!comicsList.isNullOrEmpty()) {
                categoriesAr.add(AllCategories("Comics", comicsList))
            } else {
                //Toast.makeText(this@CharacterDetailsActivity, "No result", Toast.LENGTH_LONG).show()
            }
            viewModel.loadEvents()
        })
        viewModel.eventsListObserve.observe(this, Observer { eventsList ->
            if (!eventsList.isNullOrEmpty()) {
                categoriesAr.add(AllCategories("Events", eventsList))
            } else {
                //Toast.makeText(this@CharacterDetailsActivity, "No result", Toast.LENGTH_LONG).show()
            }
            viewModel.loadSeries()
        })
        viewModel.seriesListObserve.observe(this, Observer { seriesList ->
            if (!seriesList.isNullOrEmpty()) {
                categoriesAr.add(AllCategories("Series", seriesList))
            } else {
                //Toast.makeText(this@CharacterDetailsActivity, "No result", Toast.LENGTH_LONG).show()
            }
            viewModel.loadStories()
        })
        viewModel.storiesListObserve.observe(this, Observer { storiesList ->
            if (!storiesList.isNullOrEmpty()) {
                hideLoader()
                categoriesAr.add(AllCategories("Stories", storiesList))
            } else {
                hideLoader()
                //Toast.makeText(this@CharacterDetailsActivity, "No result", Toast.LENGTH_LONG).show()
            }
            parseData()
        })

        viewModel.loadComics()
    }

    private fun parseData() {
        if(categoriesAr.isEmpty()){
            activityCharacterDetailsBinding.txNoResult.visibility = View.VISIBLE
            return
        }
        activityCharacterDetailsBinding.charactersDetailsListview.layoutManager = LinearLayoutManager(this)
        allCategoriesAdapter = AllCategoriesAdapter(categoriesAr)
        activityCharacterDetailsBinding.charactersDetailsListview.adapter = allCategoriesAdapter
    }

}