package mk.padc.themovie.datas.models

import androidx.lifecycle.LiveData
import mk.padc.themovie.datas.vos.PopularMovieVO

interface MovieModel {

    fun getAllPopularMovieList(onError: (String) -> Unit) : LiveData<List<PopularMovieVO>>

    fun getAllPopularMovieFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

}