package mk.padc.themovie.datas.models

import androidx.lifecycle.LiveData
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO

interface MovieModel {

  fun getAllPopularMovieList(onError: (String) -> Unit) : LiveData<List<PopularMovieVO>>

  fun getAllPopularMovieFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getAllTopRatedMovieList(onError: (String) -> Unit) : LiveData<List<TopRateMovieVO>>

  fun getAllTopRatedMovieListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getMovieDetailById(movieId: Int,onError: (String) -> Unit) : LiveData<MovieDetailsVO>

  fun getMovieDetailFromApiAndSaveToDatabase(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit)

}