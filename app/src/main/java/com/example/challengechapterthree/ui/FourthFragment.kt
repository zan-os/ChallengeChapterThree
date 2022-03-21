package com.example.challengechapterthree.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentFourthBinding
import com.example.challengechapterthree.databinding.FragmentSecondBinding

class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFourthScreen.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_fourthFragment_to_thirdFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}