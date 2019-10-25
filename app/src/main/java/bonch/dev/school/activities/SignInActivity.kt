package bonch.dev.school.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bonch.dev.school.R

class SignInActivity : AppCompatActivity() {

    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()
        setClickListeners()
    }

    private fun setClickListeners() {

        signInButton.setOnClickListener {
            val intent = Intent(SignInActivity@ this,MainAppActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val intent = Intent(SignInActivity@ this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initViews() {
        signInButton = findViewById(R.id.sign_in_button)
        signUpButton = findViewById(R.id.sign_up_button)
    }
}
