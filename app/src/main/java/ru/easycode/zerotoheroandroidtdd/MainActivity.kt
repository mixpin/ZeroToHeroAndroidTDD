package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removeTextView = linearLayout.childCount == 1
        val disableButton = button.isEnabled
        outState.putBoolean(KEY, removeTextView)
        outState.putBoolean(KEY2, disableButton)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removeTextView = savedInstanceState.getBoolean(KEY)
        if (removeTextView)
            linearLayout.removeView(textView)
        val disableButton  = button.isEnabled
        if (disableButton)
            button.isEnabled = false
    }

    companion object {
        private const val KEY = "key"
        private const val KEY2 = "key2"
    }
}