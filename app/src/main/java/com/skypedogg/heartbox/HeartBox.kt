package com.skypedogg.heartbox

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView

class HeartBox(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {

    private var checkBox: AppCompatCheckBox
    private var animation: LottieAnimationView

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.heartbox_layout, this, true)
        checkBox = view.findViewById(R.id.checkbox)
        animation = view.findViewById(R.id.animationView)

        checkBox.setOnCheckedChangeListener { _, b ->
            if (b) animation.playAnimation()
        }
    }





}