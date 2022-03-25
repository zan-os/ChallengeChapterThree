package com.example.challengechapterthree.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getNameArgs = args.name

        binding.textViewName.text = getNameArgs

        setFragmentResultListener(REQUEST_KEY) { _, person ->
            val getAddressBundle = person.getString(EXTRA_ADDRESS)
            val getAgeBundle = person.getInt(EXTRA_AGE)
            val getJobBundle = person.getString(EXTRA_JOB)

            val getOddOrEven = if (getAgeBundle % 2 == 0) {
                "$getAgeBundle, Usia anda genap"
            } else {
                "$getAgeBundle, Usia anda ganjil"
            }

            binding.textViewAddress.visibility = View.VISIBLE
            binding.textViewAddress.text = getAddressBundle

            binding.textViewAge.visibility = View.VISIBLE
            binding.textViewAge.text = getOddOrEven

            binding.textViewJob.visibility = View.VISIBLE
            binding.textViewJob.text = getJobBundle
        }

        binding.buttonThirdScreen.setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_ADDRESS = "extraAddress"
        const val EXTRA_AGE = "extraAge"
        const val EXTRA_JOB = "extraJob"
        const val REQUEST_KEY = "requestKey"
    }
}