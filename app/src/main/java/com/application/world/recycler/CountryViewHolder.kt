package com.application.world.recycler

import android.app.Activity
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.rolfrider.countries.view.countrylist.CountryItem
import com.rolfrider.countries.R
import kotlinx.android.synthetic.main.country_recycle_view_item.view.*

class CountryViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem){
    private val imageView = viewItem.flagImageView
    private val nameView = viewItem.countryNameView

    fun bindItem(countryItem: CountryItem, onItemClick: (CountryItem, View) -> Unit){
        nameView.text = countryItem.name
        val activity = itemView.context as Activity
        GlideToVectorYou
            .init()
            .with(activity)
            .setPlaceHolder(R.drawable.ic_loading_24dp, R.drawable.ic_flag_failed)
            .load(Uri.parse(countryItem.flagUrl), imageView)
        imageView.clipToOutline = true
        itemView.setOnClickListener { onItemClick(countryItem, imageView) }
    }
}