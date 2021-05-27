package com.example.datatransfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import com.example.datatransfer.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    lateinit var binding: FragmentFirstBinding

    val mainViewModel by activityViewModels<MainViewModel>() // activity의 lifeCycle에 맞는 viewModel 생성

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {

            setFragmentResult("requestKey", bundleOf("data" to "hello"))

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_first, container, false)
        return binding.root
    }
}