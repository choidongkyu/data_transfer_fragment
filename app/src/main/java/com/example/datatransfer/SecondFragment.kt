package com.example.datatransfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    lateinit var binding: FragmentSecondBinding
    //val mainViewModel by activityViewModels<MainViewModel>() // activity의 lifeCycle에 맞는 viewModel 생성

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("data", "")
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("data" to "hello"))
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)
        return binding.root
    }
}