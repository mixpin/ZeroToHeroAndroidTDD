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

        if (savedInstanceState != null) {
            val isTextViewRemoved = savedInstanceState.getBoolean(KEY_REMOVE_TEXT_VIEW, false)
            val isButtonDisabled = savedInstanceState.getBoolean(KEY_BUTTON_ENABLED, false)

            if (isTextViewRemoved) {
                linearLayout.removeView(textView)
            }

            button.isEnabled = !isButtonDisabled
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val isTextViewRemoved = textView.parent == null
        outState.putBoolean(KEY_REMOVE_TEXT_VIEW, isTextViewRemoved)
        outState.putBoolean(KEY_BUTTON_ENABLED, !button.isEnabled)
    }

    companion object {
        private const val KEY_REMOVE_TEXT_VIEW = "remove_text_view"
        private const val KEY_BUTTON_ENABLED = "button_enabled"
    }
}