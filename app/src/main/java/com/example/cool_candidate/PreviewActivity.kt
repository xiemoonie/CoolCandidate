package com.example.cool_candidate

import android.content.Intent
import android.icu.text.MessagePattern
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreview: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        //val infoPhone = intent.getStringExtra("Phone Number")

        displayMessage()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("message") as Message
        messagePreview = """
                Hi ${message.contactName}
                my name is ${message.myDisplayName} and I am ${message.getFullJobTittle()} 
                I have a portafolio of apps to demostrate my technical skills that I can show on request 
                I am able to start a new position ${message.getStartImmediatly()}
                Please get in touch if you have any suitable roles for me.
                Thanks and best regards.
            """.trimIndent()

        message_view.setText(messagePreview)
    }

    private fun setUpButtons(message: Message, messagePreview: String) {

        send_Button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data =
                    Uri.parse("mailto: ${message.contactNumber}") // only email apps should handle this
                putExtra("sms_body", messagePreview)

            }
        }
    }

}