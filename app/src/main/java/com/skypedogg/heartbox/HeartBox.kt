package com.skypedogg.heartbox

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Checkable
import android.widget.CompoundButton
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.heartbox_layout.view.*

class HeartBox(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs), Checkable {

    var mListener: HeartboxCheckedChangeListener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.heartbox_layout, this)

        checkbox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) animationView.playAnimation()
            mListener?.onCheckedChange(compoundButton, b)
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

    fun setHeartboxCheckedChangeListener(listener: HeartboxCheckedChangeListener) {
        mListener = listener
    }

    interface HeartboxCheckedChangeListener {
        fun onCheckedChange(compoundButton: CompoundButton, checked: Boolean)
    }

}