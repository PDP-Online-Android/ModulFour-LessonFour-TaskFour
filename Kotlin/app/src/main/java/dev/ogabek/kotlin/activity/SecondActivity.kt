package dev.ogabek.kotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import dev.ogabek.kotlin.Member
import dev.ogabek.kotlin.R

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
        getInfo()

    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        backButton = findViewById(R.id.back)
        backButton.setOnClickListener {
            val member = Member(true)
            backToMainActivity(member)
        }
    }

    private fun getInfo() {
        val user = intent.getSerializableExtra("user")
        textView.text = user.toString()
    }

    private fun backToMainActivity(member: Member) {
        val returnIntent = Intent()
        returnIntent.putExtra("respond", member)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

}