package com.example.movieapp.adapter

import com.example.movieclone.model.BaseModel


interface RecyclerViewClickListener {
    fun onClickListener(position: Int,model: BaseModel)
    fun onLongClickListener(position: Int,model: BaseModel)
}