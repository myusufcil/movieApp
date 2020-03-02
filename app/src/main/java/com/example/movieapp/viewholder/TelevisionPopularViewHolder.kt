package com.example.movieapp.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.TelevisionFragmentPopularSeriesDTO
import com.example.movieapp.dto.TelevisionFragmentTopRatedDTO
import com.example.movieclone.constant.AppConstants
import com.example.movieclone.constant.AppConstants.Companion.imgSource
import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
class TelevisionPopularViewHolder(var view: View) : BaseViewHolder(view) {
    private val item_fragment_television_popular_movies_slider_txt =
        view.findViewById(R.id.item_fragment_television_popular_movies_slider_txt) as TextView
    private val item_fragment_television_popular_movies_slider_img_view =
        view.findViewById(R.id.item_fragment_television_popular_movies_slider_img_view) as ImageView
    private val item_fragment_television_popular_movies_slider_rated_txt =
        view.findViewById(R.id.item_fragment_television_popular_movies_slider_rated_txt) as TextView

    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        val items = baseModel as TelevisionFragmentPopularSeriesDTO
        item_fragment_television_popular_movies_slider_txt.text = items.name

        val url = imgSource + items.backdrop_path
        Glide.with(view.context).load(url)
            .into(item_fragment_television_popular_movies_slider_img_view)
        item_fragment_television_popular_movies_slider_rated_txt.text = items.vote_average
    }
}