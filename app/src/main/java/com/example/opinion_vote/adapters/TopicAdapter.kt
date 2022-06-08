package com.example.opinion_vote.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.opinion_vote.R
import com.example.opinion_vote.datas.Topic

class TopicAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<Topic>
) : ArrayAdapter<Topic>(mContext, resId, mList) {

    var mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = mInflater.inflate(R.layout.topic_list_item, null)

        }

        val row = tempRow!!
        return row
    }

}