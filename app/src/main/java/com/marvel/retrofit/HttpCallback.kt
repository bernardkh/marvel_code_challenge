package com.marvel.retrofit

import com.marvel.App
import com.marvel.R
import com.marvel.common.Methods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

public abstract class HttpCallback<T> : Callback<T> {
    abstract fun onRequestSuccess(call: Call<T>?, response: T?)

    abstract fun onRequestError(call: Call<T>?, response: String?)

    abstract fun onRequestFail(call: Call<T>, error: String?)

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val runnable = Runnable {
            if (response.body() != null) {
                onRequestSuccess(call, response.body())
            } else if (response.errorBody() != null) {
                try {
                    onRequestError(call, response.errorBody()!!.string())
                } catch (e: IOException) {
                    onRequestFail(
                        call, App.getContext()
                            .getString(R.string.error_empty_response)
                    )
                }
            } else {
                onRequestFail(
                    call, App.getContext()
                        .getString(R.string.error_empty_response)
                )
            }
        }
        runnable.run()
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        val runnable = Runnable {
            onRequestFail(
                call,
                Methods.getErrorMessage(App.getContext(), t)
            )
        }
        runnable.run()
    }
}