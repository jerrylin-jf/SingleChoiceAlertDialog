package com.example.jerry.singlechoicealertdialog

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var alertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alertButton = findViewById(R.id.alert_button)
        alertButton.setOnClickListener { showAlertDialog() }
    }

    private fun showAlertDialog() {

        val list = listOf("1", "2", "3", "4", "5", "a", "b", "c")
        val adapter = ArrayAdapter<CharSequence>(this, R.layout.view_checked_textview, list)

        val ad = AlertDialog.Builder(this)
        ad.setTitle("This is an alert dialog")
        ad.setSingleChoiceItems(adapter, -1) { dialog, which ->
            val checkedTv = adapter.getView(which, null, null) as CheckedTextView
            checkedTv.isChecked = true

            Toast.makeText(this, list[which], Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                dialog.dismiss()
            }, 500L)
        }

        ad.create().show()
    }
}
