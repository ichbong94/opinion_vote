package com.example.opinion_vote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.opinion_vote.utils.ContextUtil

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

//        3초후 검사 저장된 토큰이 있는 지

        val myHadnler = Handler(Looper.getMainLooper())

        myHadnler.postDelayed({

            if (ContextUtil.getToken(mContext) == "") {
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
        }
            else {
                val myIntent = Intent(mContext, MainActivity::class.java)
                startActivity(myIntent)}
             finish()



        }, 3000)

    }


}