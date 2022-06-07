package com.example.opinion_vote

import android.content.Intent
import android.os.Bundle
import android.util.JsonReader
import android.widget.Toast
import com.example.opinion_vote.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        emailCheckBtn.setOnClickListener {
            val inputEmail = emailCheckBtn.text.toString()

            ServerUtil.getRequestDupplCheck("EMAIL", inputEmail, object : ServerUtil.Companion.JsonResponseHandler{
                override fun onResponse(jsonObj: JSONObject) {



                }


            })

        }

        signUpBtn.setOnClickListener {

            val inputEmail = emEdt.text.toString()
            val inputPw = pwEdt.text.toString()
            val inputNickname = nickNameEdt.text.toString()

            ServerUtil.putRequestSignUp(
                inputEmail,
                inputPw,
                inputNickname,
                object : ServerUtil.Companion.JsonResponseHandler {
                    override fun onResponse(jsonObj: JSONObject) {
                        val code = jsonObj.getInt("code")
                        if (code == 200) {
                            val dataObj = jsonObj.getJSONObject("data")
                            val userObj = dataObj.getJSONObject("user")
                            val nickName = userObj.getString("nick_name")

                            runOnUiThread {
                                Toast.makeText(mContext, "${nickName}님, 환영합니다", Toast.LENGTH_SHORT).show()
                                finish()

                            }


                        } else {
                            val message = jsonObj.getString("message")
                            runOnUiThread {
                                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

                            }

                        }

                    }


                })


        }

    }

    override fun setValues() {

    }


}