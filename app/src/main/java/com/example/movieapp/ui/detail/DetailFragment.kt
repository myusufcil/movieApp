package com.example.movieapp.ui.detail


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.dto.DetailFragmentContentDTO
import com.example.movieapp.model.ModelDetailMovie
import com.example.movieclone.network.RetrofitMovieFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle = this.arguments
//        val id = arguments!!.getInt("id")

        val myValue = bundle!!.getInt("key", 0)
        var getMovieAccordingToId =
            RetrofitMovieFactory.createMovie().getMovieAccordingToId(myValue)
        getMovieAccordingToId.enqueue(object : Callback<ModelDetailMovie> {
            override fun onFailure(call: Call<ModelDetailMovie>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }
            override fun onResponse(
                call: Call<ModelDetailMovie>,
                response: Response<ModelDetailMovie>
            ){
                Log.d("Başarılı", "Başarılı")

            }
        })
    }
}
