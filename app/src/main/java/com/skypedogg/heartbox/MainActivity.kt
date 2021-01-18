package com.skypedogg.heartbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var hb: HeartBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hb = findViewById(R.id.heartbox)
        hb.setHeartboxCheckedChangeListener(object : HeartBox.HeartboxCheckedChangeListener{
            override fun onCheckedChange(compoundButton: CompoundButton, checked: Boolean) {
                Toast.makeText(compoundButton.context, "Checked: $checked", Toast.LENGTH_SHORT).show()
            }

        })
    }
}