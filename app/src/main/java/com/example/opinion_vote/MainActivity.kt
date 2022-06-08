package com.example.opinion_vote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.opinion_vote.datas.Topic

class MainActivity : BaseActivity() {

    var mList = ArrayList<Topic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

    }

    override fun setValues() {
        getTopiclistFromServer()
    }

    fun getTopiclistFromServer() {

    }

}