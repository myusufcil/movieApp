package com.example.movieapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapter.RecyclerViewClickListener
import com.example.movieapp.dto.TelevisionFragmentTopRatedDTO
import com.example.movieclone.constant.AppConstants
import com.example.movieclone.model.BaseModel
import kotlinx.android.synthetic.main.item_fragment_television_top_rated_slider.view.*

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/29/2020
*/
class TelevisionTopRatedViewHolder(var view: View) : BaseViewHolder(view) {
    private val item_fragment_television_top_rated_img_view =
        view.findViewById(R.id.item_fragment_television_top_rated_img_view) as ImageView
    private val item_fragment_television_top_rated_txt =
        view.findViewById(R.id.item_fragment_television_top_rated_txt) as TextView

    override fun bindView(baseModel: BaseModel, position: Int, click: RecyclerViewClickListener) {
        var item =baseModel as TelevisionFragmentTopRatedDTO
        var url=AppConstants.imgSource+item.poster_path
        Glide.with(view.context).load(url).into(item_fragment_television_top_rated_img_view )
        item_fragment_television_top_rated_txt.text=item.name
    }
}