package bonch.dev.school.fragments

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.models.MessageStorage
import bonch.dev.school.ui.MessageAdapter
import java.util.*

class ChatFragment : Fragment() {

    private lateinit var sendMessageBtn: Button
    private lateinit var messageEditText: EditText
    private lateinit var messageRecyclerView: RecyclerView

    private var messageList: MutableList<bonch.dev.school.models.Message> =
        MessageStorage().messageList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_chat, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setClickListeners()
        setRecyclerViewParams()

    }


    private fun setRecyclerViewParams() {
        messageRecyclerView.layoutManager = LinearLayoutManager(view!!.context)
        messageRecyclerView.adapter = MessageAdapter(messageList)
        messageRecyclerView.smoothScrollToPosition(messageRecyclerView.adapter?.itemCount!!)
    }

    private fun setClickListeners() {
        sendMessageBtn.setOnClickListener {
            val editTextString:String = messageEditText.text.toString()

            if (!editTextString.startsWith(" ")&& !editTextString.endsWith(" ")) {
                messageList.add(
                    bonch.dev.school.models.Message(
                        messageRecyclerView.adapter!!.itemCount,
                        messageEditText.text.toString(), Calendar.getInstance().time, true
                    )
                )
            }
            else Toast.makeText(context,"INCORRECT INPUT",Toast.LENGTH_LONG).show()
            messageRecyclerView.adapter?.notifyDataSetChanged()
            messageEditText.setText("")
            messageRecyclerView.smoothScrollToPosition(messageRecyclerView.adapter?.itemCount!!)

        }
    }

    private fun initViews(view: View) {
        sendMessageBtn = view.findViewById(R.id.send_message_button)
        messageRecyclerView = view.findViewById(R.id.message_recycler_view)
        messageEditText = view.findViewById(R.id.message_et)

    }


}