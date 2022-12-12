package com.kodego.activity.one.studentassistanceapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewPagerAdapter (
    val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

