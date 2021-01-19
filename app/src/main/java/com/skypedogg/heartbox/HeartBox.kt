package com.skypedogg.heartbox

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.Checkable
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.heartbox_layout.view.*

class HeartBox(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs), Checkable {

    private var mListener: HeartboxStateChangeListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.heartbox_layout, this)
        val heart = ContextCompat.getDrawable(context, R.drawable.heart_checked)
        animationView.layoutParams = ConstraintLayout.LayoutParams(heart!!.minimumWidth, heart!!.minimumHeight)

        checkbox.setOnClickListener { view ->
            val checkbox = view as CheckBox
            if (checkbox.isChecked) animationView.playAnimation()
            mListener?.onCheckedChange(checkbox.isChecked)
        }

    }

    override fun setChecked(checked: Boolean) {
        checkbox.isChecked = checked
    }

    override fun isChecked(): Boolean {
        return checkbox.isChecked
    }

    override fun toggle() {
        checkbox.isChecked = !checkbox.isChecked
    }

    fun isAnimating(): Boolean {
        return animationView.isAnimating
    }

    fun setHeartboxStateChangeListener(listener: HeartboxStateChangeListener) {
        mListener = listener
    }

    interface HeartboxStateChangeListener {
        fun onCheckedChange(checked: Boolean)
    }
}