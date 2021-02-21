package com.example.turismochile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.turismochile.databinding.FragmentMailBinding
import javax.security.auth.Subject

class MailFragment : Fragment() {

    private lateinit var binding: FragmentMailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mail = "mail@mail.com"
        binding.txvCorreo.setText(mail)
        var subjet = ""
        //binding.txvSubjet.toString() = subjet
        var message = ""
        //binding.edTXmessage.toString() = message
        binding.btSend.setOnClickListener {
            sendMessage(mail, subjet, message)
        }
    }
    private fun sendMessage(mail: String, subject: String, message: String){
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)



        }

    }









