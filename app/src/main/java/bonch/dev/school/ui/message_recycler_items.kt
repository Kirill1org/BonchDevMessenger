package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.models.Constants
import bonch.dev.school.models.Message
import com.bumptech.glide.Glide

class MessageAdapter(messageList: MutableList<Message>) : RecyclerView.Adapter<MessageAdapter.MessageHolder>() {

    val messagesList = messageList

    override fun getItemViewType(position: Int): Int {

        val type = when (messagesList[position].isUser) {
            true -> Constants.USER_MESSAGE
            else -> Constants.OTHER_MESSAGE
        }
        return type

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {

        val view = when (viewType) {
            Constants.USER_MESSAGE -> LayoutInflater.from(parent.context).inflate(
                R.layout.user_message_item,
                parent,
                false
            )
            else -> LayoutInflater.from(parent.context).inflate(
                R.layout.other_message_item,
                parent,
                false
            )
        }
        LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return MessageHolder(view)
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }


    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(position, holder.itemViewType,holder.itemView)

    }

    inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(position: Int, viewType: Int, view: View) {

            if (viewType == Constants.USER_MESSAGE) {
                val userMessageText=itemView.findViewById<TextView>(R.id.message_user_text_view)
                userMessageText.setText(messagesList.get(position).messageText)

                val userMessageDate=itemView.findViewById<TextView>(R.id.message_user_date_text_view)
                userMessageDate.setText(messagesList.get(position).sentDate.toString())

            }
            if (viewType == Constants.OTHER_MESSAGE) {

                val otherMessageText=itemView.findViewById<TextView>(R.id.message_other_text_view);
                otherMessageText.setText(messagesList.get(position).messageText);

                val otherMessageDate=itemView.findViewById<TextView>(R.id.message_other_date_text_view)
                otherMessageDate.setText(messagesList.get(position).sentDate.toString());

               val otherImageAvatar = itemView.findViewById<ImageView>(R.id.avatar_other_image_view);

                Glide.with(view.context)
                    .load(R.drawable.cat)
                    .into(otherImageAvatar)

            }

        }

    }
}