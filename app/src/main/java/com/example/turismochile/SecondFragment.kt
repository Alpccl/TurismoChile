package com.example.turismochile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.turismochile.databinding.FragmentSecondBinding
import com.example.turismochile.viewModel.RegionViewModel


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: RegionViewModel by activityViewModels()
    private var idRegion: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idRegion = it.getString("id", "")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getInformationById(idRegion).observe(viewLifecycleOwner, Observer {
            it?.let {
                Glide.with(binding.imvTurism2).load(it).into(binding.imvTurism2)
                binding.tvTurism2.text = it.description


            }
        })

        binding.btOtherTurist2.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_mailFragment)
        }
    }
}



