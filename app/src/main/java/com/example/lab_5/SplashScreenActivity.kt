package com.example.lab_5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

class SplashScreenActivity : AppCompatActivity() {

    private val TAG = "SplashScreenActivity"
    private val SPLASH_SCREEN_DURATION = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        supportActionBar?.hide()

        Log.d(TAG, "onCreate() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onCreate()", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_DURATION)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() - SplashScreenActivity")
        Toast.makeText(this, "SplashScreen: onDestroy()", Toast.LENGTH_SHORT).show()
    }
}