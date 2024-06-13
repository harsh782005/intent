package com.harsh.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var number: Button?=null
    var web:Button?=null
    var btnsms:Button?=null
    var btnemail:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        number=findViewById(R.id.dial)
        web=findViewById(R.id.web)
        btnsms=findViewById(R.id.btnsms)
        btnemail=findViewById(R.id.btnmail)
        btnemail?.setOnClickListener {
            try{
                var intent=Intent(Intent.ACTION_SEND)
                intent.setType("text/email")


                startActivity(intent)
            }catch (exception:Exception){
                Toast.makeText(this, "Sorry cannot compose a  mail", Toast.LENGTH_LONG).show()
            }
        }

        number?.setOnClickListener {
            try {
                var intent= Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:9878145781"))
                startActivity(intent)
            }catch (exception : Exception){
                Toast.makeText(this, "Sorry cannot dial a number", Toast.LENGTH_LONG).show()
            }
        }
        web?.setOnClickListener {
            var intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://o7services.com/"))
            startActivity(intent)
        }
        btnsms?.setOnClickListener {
            var intent=Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("sms:9874751587"))
            startActivity(intent)
        }



    }
}