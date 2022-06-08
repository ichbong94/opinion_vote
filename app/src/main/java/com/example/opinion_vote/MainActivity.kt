package com.example.opinion_vote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.opinion_vote.adapters.TopicAdapter
import com.example.opinion_vote.datas.Topic
import com.example.opinion_vote.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

//    var List = ArrayList<Topic>()

    var mTopicList = ArrayList<Topic>()

    lateinit var mTopicAdapter: TopicAdapter

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

        mTopicAdapter = TopicAdapter(mContext, R.layout.topic_list_item, mTopicList)
        topicListView.adapter = mTopicAdapter
    }

    fun getTopiclistFromServer() {
        ServerUtil.getRequestMainInfo(mContext, object : ServerUtil.Companion.JsonResponseHandler {
            override fun onResponse(jsonObj: JSONObject) {
                val dataObj = jsonObj.getJSONObject("data")
                val topicsArr = dataObj.getJSONArray("topics")

                for (index in 0 until topicsArr.length()) {
                    val topicObj = topicsArr.getJSONObject(index)
                    val topicData = Topic.getTopicDataFromJson(topicObj)
                    mTopicList.add(topicData)

                }

                runOnUiThread() {
                    mTopicAdapter.notifyDataSetChanged()

                }


            }


        })

    }

}