package scisrc.mobiledev.firstuiassignment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    lateinit var backToMainBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginTextView = findViewById<TextView>(R.id.textView6)

        val text = "Don't have an account? Sign Up"

        val spannable = SpannableString(text)
        val boldSpan = StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan, text.indexOf("Sign Up"), text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        loginTextView.text = spannable

        loginTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        backToMainBtn = findViewById(R.id.loginBackToMainBtn)

        backToMainBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}