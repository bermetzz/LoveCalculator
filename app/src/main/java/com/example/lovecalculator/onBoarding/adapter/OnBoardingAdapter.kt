package com.example.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.OnBoard
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnboardingBinding


class OnBoardingAdapter(private val onClick: () -> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val onBoardData = arrayListOf(
        OnBoard("It's Fun and Many more", "Have a leisure time? Spend it with us, you won't be bored. We promise!", R.drawable.img),
        OnBoard("Have a good time", "You should take the time to help those who need you", R.drawable.img_1),
        OnBoard("Cherishing love", "It is now no longer possible for you to cherish love", R.drawable.img),
        OnBoard("Have a breakup?", "We have made the correction for you. Don't worry, maybe someone is waiting for you!", R.drawable.img_1)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardData[position])
    }

    override fun getItemCount(): Int {
        return onBoardData.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) : ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDescription.text = onBoard.description
            onBoard.image?.let { binding.image.setImageResource(it) }
            binding.btnStart.isVisible = adapterPosition == onBoardData.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
        }
    }
}