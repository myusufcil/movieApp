package com.example.movieapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.HomeFragmentPopularMovieListDTO
import com.example.movieclone.constant.AppConstants
import com.example.movieclone.model.BaseModel

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
class HomePopularMoviesViewHolder(var view: View) : BaseViewHolder(view) {
    private val item_fragment_home_popular_movies_img_view =
        view.findViewById(R.id.item_fragment_home_popular_movies_slider_img_view) as ImageView
    private val item_fragment_home_popular_movies_txt =
        view.findViewById(R.id.item_fragment_home_popular_movies_slider_txt) as TextView
    private val item_fragment_home_popular_vote_average_txt =
        view.findViewById(R.id.item_fragment_home_popular_vote_average_txt) as TextView

    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        val item = baseModel as HomeFragmentPopularMovieListDTO
        val url = AppConstants.imgSource + item.poster_path
        Glide.with(view.context).load(url).into(item_fragment_home_popular_movies_img_view)
        item_fragment_home_popular_movies_txt.text=item.title
        item_fragment_home_popular_vote_average_txt.text=item.vote_average
    }
}