package com.example.movieapp.viewholder

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.HomeFragmentNowPlayingMovieListDTO
import com.example.movieapp.ui.detail.DetailFragment
import com.example.movieclone.constant.AppConstants
import com.example.movieclone.model.BaseModel


/*
Created by Muhammed Yusuf ÇİL 
Date : 2/27/2020
*/
class HomeNowPlayingViewHolder(var view: View) : BaseViewHolder(view) {
    private val item_movies_page_movie_img_view =
        view.findViewById(R.id.item_movies_page_movie_img_view) as ImageView
    private val item_movies_page_movie_name_txt =
        view.findViewById(R.id.item_movies_page_now_playing_movie_name_txt) as TextView

    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        val item = baseModel as HomeFragmentNowPlayingMovieListDTO
        val url = AppConstants.imgSource + item.poster_path
        Glide.with(view.context).load(url).into(item_movies_page_movie_img_view)
        item_movies_page_movie_name_txt.text = item.title

        view.setOnClickListener {
//            var detailFragment=DetailFragment()
//            val args = Bundle()
//            args.putInt("id",item.id)
//            detailFragment.arguments = args
            val bundle = Bundle()
            bundle.putInt("detailId",item.id)
        }
    }
}