package bonch.dev.school.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Message(
    val messageId: Int,
    val messageText: String,
    val sentDate: Date,
    val isUser: Boolean
)

class MessageStorage():Parcelable {

    val messageList: MutableList<Message>

    constructor(parcel: Parcel) : this() {
    }

    init {
        messageList = mutableListOf()
        for (i in 1..11) messageList.add(Message(i, "KEK KEK KEK KEK KEK KEK KEK KEK KEK KEK KEK KEK",Calendar.getInstance().time,true))
        for (i in 11..21) messageList.add(Message(i, "LOL LOL LOL LOL LOL",Calendar.getInstance().time,false))
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeList(messageList as List<*>?)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MessageStorage> {
        override fun createFromParcel(parcel: Parcel): MessageStorage {
            return MessageStorage(parcel)
        }

        override fun newArray(size: Int): Array<MessageStorage?> {
            return arrayOfNulls(size)
        }
    }

}