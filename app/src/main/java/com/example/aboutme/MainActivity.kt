package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aboutme.databinding.ActivityCustomMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.custom_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.doneBtn.setOnClickListener {
            addNickname(it)
        }

    }

    fun addNickname(view: View) {
        binding.apply {
            val editText = binding.nicknameEdit
            val nickNameTextView = binding.nicknameText
            invalidateAll()
            nickNameTextView.text = editText.text
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nickNameTextView.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}