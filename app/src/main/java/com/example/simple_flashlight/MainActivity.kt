package com.example.simple_flashlight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_flashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var flash: Flash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val buttonActivation = binding.btnActivate
        flash = Flash(this)

        buttonActivation.setOnClickListener {
            if (!flash.isFlashStatusOn()) {
                flash.flashOn()
                buttonActivation.setBackgroundColor(getColor(R.color.flashOffColor))
                buttonActivation.text = getString(R.string.off)
            } else {
                flash.flashOff()
                buttonActivation.setBackgroundColor(getColor(R.color.flashOnColor))
                buttonActivation.text = getString(R.string.on)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (flash.isFlashStatusOn()){
            flash.flashOff()
        }
    }

}