package com.example.lovecalculator

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentInputBinding
import com.example.lovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        if (!isUserSeen()) {
            findNavController().navigate(R.id.onBoardingFragment)
        }
    }

    private fun isUserSeen(): Boolean {
        return sharedPreferences.getBoolean(SEEN_KEY, false)
    }

    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                    .observe(viewLifecycleOwner, Observer { loveModel ->
                        Log.e("bzz", "initClicker: $loveModel")
                        App.appDatabase.loveDao().insert(loveModel)
                        findNavController().navigate(
                            R.id.outputFragment,
                            bundleOf(DATA to loveModel)
                        )
                    })
            }
        }
    }

    companion object {
        const val DATA = "DATA"
        const val SEEN_KEY = "seen.key"
    }
}