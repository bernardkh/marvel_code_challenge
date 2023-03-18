package com.marvel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marvel.beans.Characters
import com.marvel.beans.Results
import com.marvel.config.Constants
import com.marvel.retrofit.APIUtils
import com.marvel.retrofit.HttpCallback
import com.marvel.retrofit.URLs
import retrofit2.Call

class CharactersViewModel : ViewModel() {

    private val resultsList: MutableLiveData<ArrayList<Results>?> =
        MutableLiveData<ArrayList<Results>?>()

    val resultsListObserver: MutableLiveData<ArrayList<Results>?>
        get() = resultsList

    fun makeApiCall() {
        val call = APIUtils().getService(URLs.baseURL)
            .loadHome(Constants.publicKey, Constants.ts, Constants.getHash())
        call.enqueue(object : HttpCallback<Characters>() {
            override fun onRequestSuccess(call: Call<Characters>?, response: Characters?) {
                if (response != null) {
                    resultsList.postValue(response.data.results)
                } else {
                    resultsList.postValue(java.util.ArrayList<Results>())
                }
            }

            override fun onRequestError(call: Call<Characters>?, response: String?) {
                resultsList.postValue(java.util.ArrayList<Results>())
            }

            override fun onRequestFail(call: Call<Characters>, error: String?) {
                resultsList.postValue(java.util.ArrayList<Results>())
            }
        })
    }


}