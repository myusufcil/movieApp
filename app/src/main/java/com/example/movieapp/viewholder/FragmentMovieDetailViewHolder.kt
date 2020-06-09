package com.example.movieapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.DetailFragmentContentDTO
import com.example.movieclone.constant.AppConstants.Companion.imgSource
import com.example.movieclone.model.BaseModel


/*
Created by Muhammed Yusuf ÇİL 
Date : 3/10/2020
*/
class FragmentMovieDetailViewHolder(var view: View) : BaseViewHolder(view) {
    private val item_fragment_movie_detail_img_backdrop_path =
        view.findViewById(R.id.item_fragment_movie_detail_img_backdrop_path) as ImageView

    private val item_fragment_movie_detail_img_poster_path =
        view.findViewById(R.id.item_fragment_movie_detail_img_poster_path) as ImageView

    private val item_fragment_movie_detail_text_title =
        view.findViewById(R.id.item_fragment_movie_detail_text_title) as TextView

    private val item_fragment_movie_detail_txt_genders =
        view.findViewById(R.id.item_fragment_movie_detail_txt_genders) as TextView

    private val item_fragment_movie_detail_txt_vote =
        view.findViewById(R.id.item_fragment_movie_detail_txt_vote) as TextView

    private val item_fragment_movie_detail_rating_bar =
        view.findViewById(R.id.item_fragment_movie_detail_rating_bar) as RatingBar

    private val item_fragment_movie_detail_txt_overview=
        view.findViewById(R.id.item_fragment_movie_detail_txt_overview) as TextView

    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        val item= baseModel as DetailFragmentContentDTO

        val url_backdrop_path=imgSource+item.backdrop_path
        val url_poster_path=imgSource+item.poster_path
        Glide.with(view.context).load(url_backdrop_path).into(item_fragment_movie_detail_img_backdrop_path)
        Glide.with(view.context).load(url_poster_path).into(item_fragment_movie_detail_img_poster_path)
        item_fragment_movie_detail_text_title.text=item.title
        item_fragment_movie_detail_txt_genders.text=item.name
        item_fragment_movie_detail_txt_vote.text = item.vote_average.toString()
        item_fragment_movie_detail_rating_bar.rating=item.vote_average
        item_fragment_movie_detail_txt_overview.text=item.overview
    }
}


