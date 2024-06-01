package com.example.siili

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class MainActivity : AppCompatActivity() {

    private lateinit var mealTextView: TextView
    private lateinit var scanButton: Button
    private var sentence: String = "Sul on 7 päeva tasuta praeni!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealTextView = findViewById(R.id.mealTextView)
        scanButton = findViewById(R.id.scanButton)
        mealTextView.text = sentence

        scanButton.setOnClickListener {
            val integrator = IntentIntegrator(this@MainActivity)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setPrompt("Scan a QR code")
            integrator.setBeepEnabled(true)
            integrator.setBarcodeImageEnabled(true)
            integrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        result?.let {
            if (it.contents != null) {
                // Handle the QR code content here
                // For this example, we'll assume the QR code scan always means subtracting 1
                sentence = StringUtil.countdownNumberInSentence(sentence)
                mealTextView.text = sentence
            }
        } ?: super.onActivityResult(requestCode, resultCode, data)
    }
}

