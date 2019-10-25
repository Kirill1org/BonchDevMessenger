package bonch.dev.school.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bonch.dev.school.R
import bonch.dev.school.fragments.ChatFragment
import bonch.dev.school.fragments.ProfileFragment

class MainAppActivity : AppCompatActivity() {

    val fm = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)

        showChatFragment()
    }

    private fun showChatFragment() {

        val chatFragment = ChatFragment()

        fm
            .beginTransaction()
            .replace(R.id.fragment_container, chatFragment)
            .commit()
    }

    fun showProfileFragment() {

        val profileFragment = ProfileFragment()

        fm
            .beginTransaction()
            .replace(R.id.fragment_container, profileFragment)
            .addToBackStack("profileFragment")
            .commit()
    }
}
