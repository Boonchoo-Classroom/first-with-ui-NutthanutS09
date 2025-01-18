package scisrc.mobiledev.firstuiassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    lateinit var backToMainPageBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUpTextView = findViewById<TextView>(R.id.textView2)

        val text = "Don't have an account? Sign Up"

        val spannable = SpannableString(text)
        val boldSpan = StyleSpan(Typeface.BOLD)
        spannable.setSpan(boldSpan, text.indexOf("Sign Up"), text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        signUpTextView.text = spannable

        signUpTextView.setOnClickListener {
            // Start the LoginActivity when the TextView is clicked
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        backToMainPageBtn = findViewById(R.id.registBackToMainBtn)

        backToMainPageBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}