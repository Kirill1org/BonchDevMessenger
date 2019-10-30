package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.R


class ProfileFragment : Fragment() {

    private lateinit var changePassBtn: Button
    private lateinit var passwordFragment: PasswordFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initViews(view)
        setClickListeners()
    }

    private fun setClickListeners() {
        changePassBtn.setOnClickListener {
            passwordFragment = PasswordFragment()

            passwordFragment.show(MainAppActivity@ this.fragmentManager, "passwordFragment")


        }
    }

    private fun initViews(view: View) {
        changePassBtn = view.findViewById(R.id.change_password_button)
    }

}