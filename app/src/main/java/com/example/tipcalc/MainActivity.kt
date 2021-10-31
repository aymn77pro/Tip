package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalc.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.calculateButton.setOnClickListener { calculateTip() }
    }
    fun calculateTip(){
     val  StringInText = binding.costOfService.text.toString()
        val cost = StringInText.toDouble()
     val selectP = binding.tipButten.checkedRadioButtonId
       val tipPercentage= when(selectP){
           R.id.amazing -> .2
           R.id.good -> .18
           R.id.ok -> .15
           else -> 0.0
       }
        var tip = tipPercentage * cost + cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount,formattedTip)

    }
}