package com.sitthirat.cntandroidtest.view.main.first.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.sitthirat.cntandroidtest.databinding.ViewHolderFirstBinding
import com.sitthirat.cntandroidtest.model.response.GetJsonDataModel

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class FirstRecyclerAdapter : RecyclerView.Adapter<FirstRecyclerAdapter.FirstViewHolder>() {

    var jsonDataList: ArrayList<GetJsonDataModel>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val binding = ViewHolderFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstViewHolder(binding.root)
    }

    override fun getItemCount(): Int = jsonDataList?.size ?: 0

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bindView(jsonDataList!![position], position)
    }

    inner class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ViewHolderFirstBinding = DataBindingUtil.bind(itemView)!!

        fun bindView(getJsonDataModel: GetJsonDataModel, position: Int) {
            binding.ivImage.load(getJsonDataModel.img?.replace("http://http://","http://"))
            binding.tvName.text = getJsonDataModel.name
            binding.tvDescription.text = getJsonDataModel.desc
            binding.tvAuthor.text = getJsonDataModel.author
            binding.tvCategory.text = getJsonDataModel.cName
            binding.tvScore.text = getJsonDataModel.score.toString()
        }
    }
}