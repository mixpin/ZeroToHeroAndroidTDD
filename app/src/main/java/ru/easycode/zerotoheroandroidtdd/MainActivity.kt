package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val count = Count.Base(step = 2, max = 4)
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            val result = count.increment(textView.text.toString())
            textView.text = result
            if (count.isMax(result))
                button.isEnabled = false
        }

        if (savedInstanceState != null) {
            val isButtonDisabled = savedInstanceState.getBoolean(KEY_BUTTON_ENABLED, false)
            button.isEnabled = !isButtonDisabled
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_BUTTON_ENABLED, !button.isEnabled)
    }

    companion object {
        private const val KEY_BUTTON_ENABLED = "button_enabled"
    }
}