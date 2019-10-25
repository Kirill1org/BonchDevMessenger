package bonch.dev.school.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bonch.dev.school.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var completeSignUpBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        setClickListeners()
    }

    private fun setClickListeners() {
        completeSignUpBtn.setOnClickListener {
            val intent = Intent(SignUpActivity@this,MainAppActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        completeSignUpBtn=findViewById(R.id.complete_sign_up_button)
    }
}
