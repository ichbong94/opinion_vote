package com.example.opinion_vote.datas

import org.json.JSONObject

class Topic {

    var id = 0 //나중에 정수 명시
    var title =""
    var imageURL =""

    companion object {

        fun getTopicDataFromJson(jsonObj : JSONObject) : Topic{

            val resultTopic = Topic()
            resultTopic.id = jsonObj.getInt("id")
            resultTopic.title = jsonObj.getString("title")
            resultTopic.imageURL = jsonObj.getString("img_url")
            return resultTopic

        }
    }

}