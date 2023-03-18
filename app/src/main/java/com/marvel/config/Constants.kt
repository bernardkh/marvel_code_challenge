package com.marvel.config

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Constants {


    const val CharacterID: String = "character_id"
    const val CharacterName: String = "character_name"
    const val ts : String = "1"
    const val publicKey: String = "6aa38d232084a504f175121bd9066be2"
    private const val privateKey: String = "f2667dbe7f310b316d03ea68ad923e5f0fe73ecb"

    fun getHash(): String {
        val stringToHash = ts + privateKey + publicKey
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(stringToHash.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = java.lang.StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }
}