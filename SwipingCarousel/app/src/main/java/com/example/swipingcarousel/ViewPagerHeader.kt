package com.example.swipingcarousel

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout

class ViewPagerHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {
    private var numberOfPages = 0

    fun setPagesCount(pages: Int) {
        numberOfPages = pages
    }

    fun setCurrentProgress(currentProgress: Float) {
        progress = currentProgress
    }
}