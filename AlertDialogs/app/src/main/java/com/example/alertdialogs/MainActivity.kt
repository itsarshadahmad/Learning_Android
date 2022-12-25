package com.example.alertdialogs

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.alertdialogs.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // AlertDialog.Builder class will create new dialog
        // We can set appropriate options to customize to requirement.
        val addContactDialog = AlertDialog.Builder(this).setTitle("Add contact")
            .setMessage("Do you want to add Joe to your contact list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                // Dialog interface is required in order to make it interactive
                Snackbar.make(binding.root, "Added to your contact list", Snackbar.LENGTH_LONG)
                    .show()
            }.setNegativeButton("No") { _, _ ->
                Snackbar.make(binding.root, "Canceled.", Snackbar.LENGTH_LONG).show()
            }.create() // this will create dialog

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show() // will show dialog on click event
        }

        val options = arrayOf("First", "Second", "Third")
        val singleChoiceDialog = AlertDialog.Builder(this).setTitle("Choose of these options")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You have clicked on ${options[i]}.", Toast.LENGTH_LONG).show()
            }.setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                Snackbar.make(
                    binding.root, "You have accepted.", Snackbar.LENGTH_LONG
                ).show()
            }.setNegativeButton("Decline") { _: DialogInterface, _: Int ->
                Snackbar.make(binding.root, "You have declined.", Snackbar.LENGTH_LONG).show()
            }.create()

        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this).setTitle("Choose one of these option")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You have checked ${options[i]}.", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(this, "You have unchecked ${options[i]}.", Toast.LENGTH_LONG)
                        .show()
                }
            }.setPositiveButton("Accept") { _: DialogInterface, _: Int ->
                Snackbar.make(
                    binding.root, "You have accepted.", Snackbar.LENGTH_LONG
                ).show()
            }.setNegativeButton("Decline") { _: DialogInterface, _: Int ->
                Snackbar.make(binding.root, "You have declined.", Snackbar.LENGTH_LONG).show()
            }.create()

        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}