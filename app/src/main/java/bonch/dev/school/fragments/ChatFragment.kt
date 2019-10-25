package bonch.dev.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.R
import bonch.dev.school.activities.MainAppActivity

class ChatFragment : Fragment() {

    private lateinit var sendMessageBtn: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setClickListeners()
    }

    private fun setClickListeners() {
        sendMessageBtn.setOnClickListener {
            (context as MainAppActivity).showProfileFragment()

        }
    }

    private fun initViews(view: View) {
        sendMessageBtn = view.findViewById(R.id.send_message_button)

    }



}