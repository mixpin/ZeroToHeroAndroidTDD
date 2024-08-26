package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.transition.Visibility

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.hideButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            textView.visibility = View.INVISIBLE
        }
//        savedInstanceState?.let {
//            textView.visibility = View.INVISIBLE
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, textView.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.visibility = savedInstanceState.getInt(KEY)
    }

    companion object {
        private const val KEY = "visibilityKey"
    }

}