package com.example.turismochile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turismochile.databinding.FragmentFirstBinding
import com.example.turismochile.model.adapter.RegionAdapter
import com.example.turismochile.viewModel.RegionViewModel


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel : RegionViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RegionAdapter()
        binding.rvRegions.adapter = adapter
        binding.rvRegions.layoutManager = LinearLayoutManager(context)

        viewModel.getAllRegions().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedRegion().observe(viewLifecycleOwner, Observer {
            it?.let {
                val bundle = Bundle()
                bundle.putString("id", it.id)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        })

    }
}