package com.example.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.activitynavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        val name = intent.getStringExtra("NAME")
        val age = intent.getIntExtra("AGE", 0)
        val country = intent.getStringExtra("COUNTRY")
        val personString = "$name is $age years old and lives in $country."

//        use class intent data. We as also have cast as Person to deserialize object
        val person = intent.getSerializableExtra("PERSON") as Person

        binding.personTextView.text = personString
//        showing person object data
//        binding.personTextView.text = person.toString()
    }
}