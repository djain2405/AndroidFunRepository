package com.example.swipingcarousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.swipingcarousel.databinding.ActivityMainBinding
import com.example.swipingcarousel.databinding.ItemPagerViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var myViewPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            binding.lottieView.motionLayout.setCurrentProgress((position+positionOffset)/5)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPagerView.apply {
            adapter = MyViewPagerAdapter()
            isUserInputEnabled = false
            registerOnPageChangeCallback(myViewPageChangeCallback)
        }

        TabLayoutMediator(binding.indicatorTabLayout, binding.viewPagerView) {
            _, _ ->
        }.attach()

        binding.button.setOnClickListener {
            binding.viewPagerView.currentItem = binding.viewPagerView.currentItem + 1
        }
    }
}

class MyViewPagerAdapter : RecyclerView.Adapter<FruitViewHolder>() {

    private val fruitList = listOf("Apple", "Mango", "Orange", "Pear", "Berries", "Bananas")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(ItemPagerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(fruitList[position])
    }

    override fun getItemCount(): Int = fruitList.size
}

class FruitViewHolder internal constructor(private val binding: ItemPagerViewBinding)  :RecyclerView.ViewHolder(binding.root) {
    fun bind(title: String) {
        binding.textView.text = title
    }
}
