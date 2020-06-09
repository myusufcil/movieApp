package com.example.movieapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/* 
Created by Muhammed Yusuf ÇİL 
Date : 2/19/2020
*/
abstract class BaseFragment : androidx.fragment.app.Fragment() {

    abstract fun getLayout(): Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }
}