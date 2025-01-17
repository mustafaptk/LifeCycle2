package com.example.lifecycle2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        setContentView(R.layout.activity_main)

        val btnOpenSecondActivity = findViewById<Button>(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener{
            val intent=Intent(this.applicationContext,activity_second::class.java)

            intent.putExtra("key","value")
            startActivity(intent)
            }


        }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val etUserField = findViewById<EditText>(R.id.editText)
        val userField = etUserField.text.toString()
        outState.putString("userField", userField)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val userField = savedInstanceState.getString("userField")
        val etUserField = findViewById<EditText>(R.id.editText)
        etUserField.setText(userField)
    }
    }
