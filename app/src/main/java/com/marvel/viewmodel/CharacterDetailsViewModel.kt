package com.marvel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marvel.beans.Characters
import com.marvel.beans.Results
import com.marvel.config.Constants
import com.marvel.retrofit.APIUtils
import com.marvel.retrofit.HttpCallback
import com.marvel.retrofit.URLs
import retrofit2.Call


class CharacterDetailsViewModel : ViewModel() {

    private var characterId:String = ""
    private val comicsList: MutableLiveData<ArrayList<Results>?> = MutableLiveData<ArrayList<Results>?>()
    private val storiesList: MutableLiveData<ArrayList<Results>?> = MutableLiveData<ArrayList<Results>?>()
    private val eventsList: MutableLiveData<ArrayList<Results>?> = MutableLiveData<ArrayList<Results>?>()
    private val seriesList: MutableLiveData<ArrayList<Results>?> = MutableLiveData<ArrayList<Results>?>()

    val comicsListObserve: MutableLiveData<ArrayList<Results>?>
        get() = comicsList

    val storiesListObserve: MutableLiveData<ArrayList<Results>?>
        get() = storiesList

    val eventsListObserve: MutableLiveData<ArrayList<Results>?>
        get() = eventsList

    val seriesListObserve: MutableLiveData<ArrayList<Results>?>
        get() = seriesList

    fun setCharacterID(charId: String) {
        characterId = charId
    }

    //----------------------------------------------------------------------------------------------

    fun loadComics() {
        val call = APIUtils().getService(URLs.baseURL).loadAll(this.characterId,"comics",Constants.publicKey, Constants.ts, Constants.getHash())
        call.enqueue(object : HttpCallback<Characters>() {
            override fun onRequestSuccess(call: Call<Characters>?, response: Characters?) {
                if (response != null ) {
                    comicsList.postValue(response.data.results)
                }
                else {
                    comicsList.postValue(java.util.ArrayList<Results>())
                }
            }

            override fun onRequestError(call: Call<Characters>?, response: String?) {
                comicsList.postValue(java.util.ArrayList<Results>())
            }
            override fun onRequestFail(call: Call<Characters>, error: String?) {
                comicsList.postValue(java.util.ArrayList<Results>())
            }
        })

    }

    //----------------------------------------------------------------------------------------------

    fun loadEvents() {
        val call = APIUtils().getService(URLs.baseURL).loadAll(this.characterId,"events",Constants.publicKey, Constants.ts, Constants.getHash())
        call.enqueue(object : HttpCallback<Characters>() {
            override fun onRequestSuccess(call: Call<Characters>?, response: Characters?) {
                if (response != null ) {
                    eventsList.postValue(response.data.results)
                }
                else {
                    eventsList.postValue(java.util.ArrayList<Results>())
                }
            }

            override fun onRequestError(call: Call<Characters>?, response: String?) {
                eventsList.postValue(java.util.ArrayList<Results>())
            }
            override fun onRequestFail(call: Call<Characters>, error: String?) {
                eventsList.postValue(java.util.ArrayList<Results>())
            }
        })
    }

    //----------------------------------------------------------------------------------------------

    fun loadSeries() {
        val call = APIUtils().getService(URLs.baseURL).loadAll(this.characterId,"series",Constants.publicKey, Constants.ts, Constants.getHash())
        call.enqueue(object : HttpCallback<Characters>() {
            override fun onRequestSuccess(call: Call<Characters>?, response: Characters?) {
                if (response != null ) {
                    seriesList.postValue(response.data.results)
                }
                else {
                    seriesList.postValue(java.util.ArrayList<Results>())
                }
            }

            override fun onRequestError(call: Call<Characters>?, response: String?) {
                seriesList.postValue(java.util.ArrayList<Results>())
            }
            override fun onRequestFail(call: Call<Characters>, error: String?) {
                seriesList.postValue(java.util.ArrayList<Results>())
            }
        })

    }

    //----------------------------------------------------------------------------------------------

    fun loadStories() {
        val call = APIUtils().getService(URLs.baseURL).loadAll(this.characterId,"stories",Constants.publicKey, Constants.ts, Constants.getHash())
        call.enqueue(object : HttpCallback<Characters>() {
            override fun onRequestSuccess(call: Call<Characters>?, response: Characters?) {
                if (response != null ) {
                    storiesList.postValue(response.data.results)
                }
                else {
                    storiesList.postValue(java.util.ArrayList<Results>())
                }
            }

            override fun onRequestError(call: Call<Characters>?, response: String?) {
                storiesList.postValue(java.util.ArrayList<Results>())
            }
            override fun onRequestFail(call: Call<Characters>, error: String?) {
                storiesList.postValue(java.util.ArrayList<Results>())
            }
        })

    }
    //----------------------------------------------------------------------------------------------


}