package com.example.lab_5
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.lab_5.R
import com.example.lab_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

        val isNightMode = sharedPreferences.getBoolean("night_mode", false)
        binding.switch1.isChecked = isNightMode
        updateSwitchText(isNightMode)

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("night_mode", isChecked).apply()

            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            updateSwitchText(isChecked)

            recreate()
        }


        binding.button.setOnClickListener {
            val weightString = binding.waga.text.toString()
            val heightString = binding.wzrost.text.toString()

            if (weightString.isEmpty() || heightString.isEmpty()) {
                binding.textView.text = "Wprowadź wagę i wzrost"
                binding.textView2.text = ""
                binding.imageView.setImageResource(0)
                return@setOnClickListener
            }

            val weightDouble = weightString.toDouble()
            val heightDouble = heightString.toDouble() / 100

            val bmi = weightDouble / (heightDouble * heightDouble)
            val roundedBMI = String.format("%.1f", bmi)

            when {
                bmi < 18.5 -> {
                    binding.textView.text = "Niedowaga"
                    binding.textView2.text = "BMI: $roundedBMI"
                    binding.imageView.setImageResource(R.drawable.stick)
                }
                bmi >= 18.5 && bmi < 24.9 -> {
                    binding.textView.text = "Norma"
                    binding.textView2.text = "BMI: $roundedBMI"
                    binding.imageView.setImageResource(R.drawable.pepe)
                }
                bmi >= 24.9 && bmi < 29.9 -> {
                    binding.textView.text = "Nadwaga"
                    binding.textView2.text = "BMI: $roundedBMI"
                    binding.imageView.setImageResource(R.drawable.halt)
                }
                else -> { // bmi >= 29.9
                    binding.textView.text = "Otyłość"
                    binding.textView2.text = "BMI: $roundedBMI"
                    binding.imageView.setImageResource(R.drawable.skull)
                }
            }
        }

    }
    private fun updateSwitchText(isNightMode: Boolean) {
        binding.switch1.text = if (isNightMode) "Tryb Dzienny" else "Tryb Nocny"
    }
}