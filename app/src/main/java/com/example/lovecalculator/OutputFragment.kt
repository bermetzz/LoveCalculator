package com.example.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentOutputBinding
import com.example.lovecalculator.remote.LoveModel

@Suppress("DEPRECATION")
class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOutputBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable(InputFragment.DATA) as LoveModel
        with(binding) {
            firstTv.text = data.firstName
            secondTv.text = data.secondName
            percentageTv.text = data.percentage + "%"
            messageTv.text = data.result
            againBtn.setOnClickListener {
                findNavController().navigateUp()
            }
            historyBtn.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }
}