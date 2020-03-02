package com.example.movieapp.dto

import com.example.movieapp.viewholder.BaseViewHolder
import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
data class TelevisionFragmentTopRatedDTO(
    var name:String,
    var poster_path:String
):BaseModel {
    override val type: Int
        get() =BaseModel.TYPE_ITEM_FRAGMENT_TELEVISION_TOP_RATED_LIST
}