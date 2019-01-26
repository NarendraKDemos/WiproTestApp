package com.techguys.wiprotestapp.ui.feeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.techguys.wiprotestapp.R
import com.techguys.wiprotestapp.databinding.ItemFeedsBinding
import com.techguys.wiprotestapp.ui.models.Feed

class FeedsRecyclerViewAdapter: RecyclerView.Adapter<FeedsRecyclerViewAdapter.FeedsViewHolder>(){

    private val feeds = mutableListOf<Feed>()
    private var inflater: LayoutInflater? = null

    fun addItems(matches: List<Feed>) {
        feeds.clear()
        feeds.addAll(matches)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        if (inflater == null) inflater = LayoutInflater.from(parent.context)
        val binding: ItemFeedsBinding = DataBindingUtil.inflate(inflater!!, R.layout.item_feeds, parent, false)
        return FeedsViewHolder(binding)
    }

    override fun getItemCount(): Int = feeds.size

    override fun onBindViewHolder(holder: FeedsViewHolder, position: Int) {
        holder.binding.feed = feeds[position]
        holder.binding.executePendingBindings()
    }


    class FeedsViewHolder(val binding: ItemFeedsBinding): RecyclerView.ViewHolder(binding.root)

}