package com.example.fragmentanduinavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// passing layout to Fragment constructor will also populates passed layout and if
// purpose of onCreateView is just inflating layout then you can save some lines of code.
// This will inflate layout to our fragment.
class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}