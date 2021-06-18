package com.example.roomtut.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomtut.R
import com.example.roomtut.data.MarkerViewModel
import com.example.roomtut.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var mMarkerViewModel: MarkerViewModel

    private var _binding: FragmentListBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // val view =  inflater.inflate(R.layout.fragment_list, container, false)
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root


        val adapter = com.example.roomtut.fragments.list.ListAdapter()
        val recyclerView = binding.recyclerView
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mMarkerViewModel = ViewModelProvider(this).get(MarkerViewModel::class.java)
        mMarkerViewModel.readAllData.observe(viewLifecycleOwner, Observer { marker ->
            adapter.setData(marker)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }


}