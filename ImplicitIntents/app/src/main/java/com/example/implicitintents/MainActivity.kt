package com.example.implicitintents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    private lateinit var ivPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)
        ivPhoto = findViewById(R.id.ivPhoto)
        btnTakePhoto.setOnClickListener {
            // Get content using implicit intent
            Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                type = "image/*" // MIME image type
                activityResultLauncher.launch(this)
            }
        }
    }

    private val activityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            // Image or any content in android is considered as URI
            val uri = activityResult.data?.data
//            ivPhoto.setImageURI(uri)
            Glide.with(this).load(uri).into(ivPhoto)
            Toast.makeText(this, "$uri", Toast.LENGTH_LONG).show()
        }
    }
}