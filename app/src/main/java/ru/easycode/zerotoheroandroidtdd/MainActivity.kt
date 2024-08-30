package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val count = Count.Base(2, 4)
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var uiState: UiState = UiState.Base("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = savedInstanceState.getSerializable(KEY) as UiState
        uiState.apply(textView, button)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
//            if (count.isMax(result))
//                button.isEnabled = false
//        }
//
//        if (savedInstanceState != null) {
//            val isButtonDisabled = savedInstanceState.getBoolean(KEY_BUTTON_ENABLED, false)
//            button.isEnabled = !isButtonDisabled
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putBoolean(KEY_BUTTON_ENABLED, !button.isEnabled)
//    }
//
//    companion object {
//        private const val KEY_BUTTON_ENABLED = "button_enabled"
//    }
        }