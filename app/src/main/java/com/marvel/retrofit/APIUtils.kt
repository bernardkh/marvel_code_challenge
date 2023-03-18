package com.marvel.retrofit

import com.marvel.interfaces.GeneralCall

class APIUtils {
    fun getService(baseURL: String): GeneralCall {//, requestBody: RequestBody?
        val headers = HashMap<String, String>()
        headers["Content-Type"] = "multipart/form-data"
        headers["Accept"] = "application/json"
        return ApiClient().getClient(baseURL, headers, null)!!.create(GeneralCall::class.java)//, requestBody
    }
}