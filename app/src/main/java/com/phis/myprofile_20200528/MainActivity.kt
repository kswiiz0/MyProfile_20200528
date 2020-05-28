package com.phis.myprofile_20200528

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_MES_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickNameBtn.setOnClickListener {

            val myIntent = Intent(this, NicknameModifyActivity::class.java)
            startActivityForResult(myIntent, REQ_MES_CODE)


        }


        dialBtn.setOnClickListener {
            val phoneNumber = phoneNumEdt.text.toString()
            val myuri = Uri.parse("tel:${phoneNumber}")
            val myIntent = Intent(Intent.ACTION_DIAL, myuri)
            startActivity(myIntent)

        }


        sendToBtn.setOnClickListener {
            val phoneNumber = phoneNumEdt.text.toString()
            val message = smsEdt.text.toString()
            val myuri = Uri.parse("sendto:${phoneNumber}")
            val myIntent = Intent(Intent.ACTION_DIAL, myuri)
            myIntent.putExtra("sms_body", message)
            startActivity(myIntent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_MES_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val nickname = data?.getStringExtra("nick")
                nickView.text = nickname



                Toast.makeText(this,"닉네임변경완료",Toast.LENGTH_SHORT).show()
            }

        }


    }


}
