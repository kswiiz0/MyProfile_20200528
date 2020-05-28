package com.phis.myprofile_20200528

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nickname_modify.*

class NicknameModifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname_modify)


        modifyBtn.setOnClickListener {
            val nickname = nicknameEdt.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("nick", nickname)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }

    }
}
