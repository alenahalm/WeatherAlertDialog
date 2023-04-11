package com.example.openweathermap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DisplayDialog(val cntxt: Context) : DialogFragment() {

    val displays = arrayOf("Brief", "Detailed")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Choose display")
                .setSingleChoiceItems(displays, -1) { dialog, which ->
                    Constants.isLong = which != 0
                    (activity as MainActivity).changeDisplay(Constants.isLong)
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") {dialog, which -> }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}