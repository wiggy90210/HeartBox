package com.skypedogg.heartbox

import android.content.Context
import android.content.res.TypedArray
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


        initAmiationView(context, attrs)
        checkbox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) animationView.playAnimation()
            mListener?.onCheckedChange(compoundButton, b)
        }
    }

    private fun initAmiationView(ctx: Context, attrs: AttributeSet?) {
        attrs?.let {
            val a: TypedArray = ctx.obtainStyledAttributes(it, R.styleable.HeartBox)
            animationView.setAnimation(a.getResourceId(R.styleable.HeartBox_checkAnim, R.raw.burst))
            animationView.speed = a.getFloat(R.styleable.HeartBox_animSpeed, 2f).toFloat()
            animationView.repeatCount = a.getInt(R.styleable.HeartBox_animRepeatCount, 1)
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

    fun setHeartboxCheckedChangeListener(listener: HeartboxCheckedChangeListener) {
        mListener = listener
    }

    interface HeartboxCheckedChangeListener {
        fun onCheckedChange(compoundButton: CompoundButton, checked: Boolean)
    }
}