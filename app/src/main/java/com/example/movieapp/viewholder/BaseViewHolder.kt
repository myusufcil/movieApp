package com.example.movieapp.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieclone.model.BaseModel

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener)
}