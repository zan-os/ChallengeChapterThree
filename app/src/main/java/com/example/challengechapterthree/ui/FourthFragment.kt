package com.example.challengechapterthree.ui

import android.app.Instrumentation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFourthScreen.setOnClickListener {
            val getAddressInput = binding.editTextAddress.text.toString()
            val getAgeInput = binding.editTextAge.text.toString().toInt()
            val getJobInput = binding.editTextJob.text.toString()

            val bundle = Bundle().apply {
                putString(ThirdFragment.EXTRA_ADDRESS, getAddressInput)
                putInt(ThirdFragment.EXTRA_AGE, getAgeInput)
                putString(ThirdFragment.EXTRA_JOB, getJobInput)
            }

            setFragmentResult(ThirdFragment.REQUEST_KEY, bundle)
            it.findNavController().navigate(R.id.action_fourthFragment_to_thirdFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}