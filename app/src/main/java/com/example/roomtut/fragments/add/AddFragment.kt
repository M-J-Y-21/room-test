package com.example.roomtut.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomtut.R
import com.example.roomtut.data.Marker
import com.example.roomtut.data.MarkerViewModel
import com.example.roomtut.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private lateinit var mMarkerViewModel: MarkerViewModel

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // val view = inflater.inflate(R.layout.fragment_add, container, false)
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        mMarkerViewModel = ViewModelProvider(this).get(MarkerViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }



        return view
    }

    private fun insertDataToDatabase() {
        val title = binding.editTextTitle.text.toString()
        val colour = binding.editTextColour.text.toString()
        val location = binding.editTextLocation.text.toString()

        if (inputCheck(title, colour, location)) {
            val marker = Marker(0, title, location, colour)
            mMarkerViewModel.addMarker(marker)
            Toast.makeText(requireContext(), "Successfuly Added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
    }

    private fun inputCheck(title: String, colour: String, location: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(colour) && TextUtils.isEmpty(location))
    }


}