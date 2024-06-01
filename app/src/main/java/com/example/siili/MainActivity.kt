package com.example.siili

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var mealTextView: TextView
    private lateinit var scanButton: Button
    private var sentence: String = "Sul on 7 päevapraadi tasuta praeni!"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealTextView = findViewById(R.id.mealTextView)
        scanButton = findViewById(R.id.scanButton)

        mealTextView.text = sentence

        scanButton.setOnClickListener {
            sentence = StringUtil.countdownNumberInSentence(sentence)
            mealTextView.text = sentence
        }
    }
}