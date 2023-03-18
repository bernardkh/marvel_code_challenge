package com.marvel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marvel.alert_dialog.MarvelAlertDialog

abstract class BaseActivity : AppCompatActivity() {
    var pDialog: MarvelAlertDialog? = null
    private var isActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pDialog = MarvelAlertDialog(this)
        pDialog!!.setCancelable(false)
    }

    abstract fun setupViews()

    open fun showLoader() {
        if (pDialog == null) {
            pDialog = MarvelAlertDialog(this)
        }
        pDialog!!.show()
    }

    open fun hideLoader() {
        val b = true
        if (b && pDialog != null) {
            pDialog!!.dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
        isActive = true
    }

    override fun onStop() {
        super.onStop()
        isActive = false
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    open fun isUIAlive(): Boolean {
        return isActive
    }
}