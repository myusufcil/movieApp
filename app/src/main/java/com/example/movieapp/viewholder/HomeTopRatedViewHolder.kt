package com.example.movieapp.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.HomeFragmentTopRatedListMovieDTO
import com.example.movieclone.constant.AppConstants.Companion.imgSource
import com.example.movieclone.model.BaseModel

class HomeTopRatedViewHolder(var view: View) : BaseViewHolder(view) {
    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        val item = baseModel as HomeFragmentTopRatedListMovieDTO
        val url = imgSource+item.backdrop_path
        Glide.with(view.context).load(url).into(item_date_icon_text_value)

    }
    private val item_date_icon_text_value = view.findViewById(R.id.item_movies_page_top_rated_movie_img) as ImageView
}