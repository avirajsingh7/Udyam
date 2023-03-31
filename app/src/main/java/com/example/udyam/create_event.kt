package com.example.udyam

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.widget.Button

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class CreateEventDialogFragment : DialogFragment() {



    private fun navigateToScheduleFragment() {
        // Get the fragment manager
        val fragmentManager = requireActivity().supportFragmentManager

        // Create a new instance of the ScheduleFragment
        val scheduleFragment = Schedule()

        // Replace the current fragment with the ScheduleFragment
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, scheduleFragment)
            .commit()
    }







    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(activity)
        val view = inflater.inflate(R.layout.create_event, null)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(view)


        // adjust the height of the dialog
        val dialog = builder.create()
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500)
        dialog.window?.attributes?.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
        }



        return dialog
    }




}
