package com.marvel.common

import android.content.Context
import androidx.core.content.ContextCompat
import com.marvel.BuildConfig
import com.marvel.R
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object Methods {

    fun getColor(context: Context, id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

    fun getErrorMessage(context: Context, t: Throwable): String? {
        val errorMessage: String? = if (BuildConfig.DEBUG) {
            t.message
        } else {
            if (t is UnknownHostException) {
                //no_internet_dialog_message
                context.getString(R.string.general_error_unknownhost)
            } else if (t is SocketTimeoutException) {
                context.getString(R.string.general_error_timeout)
            } else if (t is IOException) {
                context.getString(R.string.general_error_timeout)
            } else {
                context.getString(R.string.general_error)
            }
        }
        return errorMessage
    }





}


//object Methods {
//
//    public fun generateMd5Hash(ts: String, privateKey: String, publicKey: String): String {
//        val stringToHash = ts + privateKey + publicKey
//        val MD5 = "MD5"
//        try {
//            // Create MD5 Hash
//            val digest = MessageDigest
//                .getInstance(MD5)
//            digest.update(stringToHash.toByteArray())
//            val messageDigest = digest.digest()
//
//            // Create Hex String
//            val hexString = java.lang.StringBuilder()
//            for (aMessageDigest in messageDigest) {
//                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
//                while (h.length < 2) h = "0$h"
//                hexString.append(h)
//            }
//            return hexString.toString()
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        }
//        return ""
//    }
//
//    fun getColor(context: Context, id: Int): Int {
//        val version = Build.VERSION.SDK_INT
//        return if (version >= 23) {
//            ContextCompat.getColor(context, id)
//        } else {
//            context.resources.getColor(id)
//        }
//    }
//
//    fun getErrorMessage(context: Context, t: Throwable): String? {
//        var errorMessage: String? = ""
//        errorMessage = if (BuildConfig.DEBUG) {
//            t.message
//        } else {
//            if (t is UnknownHostException) {
//                //no_internet_dialog_message
//                context.getString(R.string.general_error_unknownhost)
//            } else if (t is SocketTimeoutException) {
//                context.getString(R.string.general_error_timeout)
//            } else if (t is IOException) {
//                context.getString(R.string.general_error_timeout)
//            } else {
//                context.getString(R.string.general_error)
//            }
//        }
//        return errorMessage
//    }
//}



