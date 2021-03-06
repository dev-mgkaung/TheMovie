package mk.padc.themovie.datas.models

import androidx.lifecycle.LiveData
import mk.padc.themovie.datas.vos.*

interface MovieModel {

  fun getAllPopularMovieList(onError: (String) -> Unit) : LiveData<List<PopularMovieVO>>

  fun getAllPopularMovieFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getAllTopRatedMovieList(onError: (String) -> Unit) : LiveData<List<TopRateMovieVO>>

  fun getAllTopRatedMovieListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getMovieDetailById(movieId: Int,onError: (String) -> Unit) : LiveData<MovieDetailsVO>

  fun getMovieDetailFromApiAndSaveToDatabase(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getAllActorList(onError: (String) -> Unit) : LiveData<List<ActorVO>>

  fun getAllActorListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getAllGenericList(onError: (String) -> Unit) : LiveData<List<GenerVO>>

  fun getAllGenericListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)


  fun getAllDiscoverListFromApi(genericname: String,onSuccess: (List<DiscoverVO>) -> Unit, onError: (String) -> Unit)

  fun getAllCrewAndCastFromApiAndSaveToDatabase(movieId: Int,onSuccess: () -> Unit, onError: (String) -> Unit)

  fun getAllCastAndCrewList(movieId: Int,onError: (String) -> Unit) : LiveData<CastCrewVO>

  fun getVideoIdByMovieId(movieId: Int,onSuccess: (List<VideoVO>) -> Unit,onError: (String) -> Unit)

}