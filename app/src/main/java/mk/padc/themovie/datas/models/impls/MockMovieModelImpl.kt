package mk.padc.themovie.datas.models.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mk.padc.themovie.datas.dummy.*
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.vos.*

object MockMovieModelImpl : MovieModel {

    var popularmovielist: MutableList<PopularMovieVO> = arrayListOf()
    var popularmovielistLiveData = MutableLiveData<List<PopularMovieVO>>()

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        val liveData = MutableLiveData<List<PopularMovieVO>>()
        liveData.postValue(getDummyPopularMovieList())
        return liveData
    }

    override fun getAllPopularMovieFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllTopRatedMovieList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        val liveData = MutableLiveData<List<TopRateMovieVO>>()
        liveData.postValue(getDummyTopRelatedMovieList())
        return liveData
    }

    override fun getAllTopRatedMovieListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getMovieDetailById(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<MovieDetailsVO> {
        val liveData = MutableLiveData<MovieDetailsVO>()
        liveData.postValue(getDummyMovieDetail())
        return liveData
    }

    override fun getMovieDetailFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllActorList(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        val liveData = MutableLiveData<List<ActorVO>>()
         liveData.postValue(getActorList())
        return liveData
    }

    override fun getAllActorListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllGenericList(onError: (String) -> Unit): LiveData<List<GenerVO>> {
        val liveData = MutableLiveData<List<GenerVO>>()
       // liveData.postValue(getDummyPopularMovieList())
        return liveData
    }

    override fun getAllGenericListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllDiscoverListFromApi(
        genericname: String,
        onSuccess: (List<DiscoverVO>) -> Unit,
        onError: (String) -> Unit
    ) {

      }


    override fun getAllCrewAndCastFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllCrewList(onError: (String) -> Unit): LiveData<List<CrewVO>> {
        val liveData = MutableLiveData<List<CrewVO>>()
         liveData.postValue(getDummyCrewList())
        return liveData
    }

    override fun getAllCastList(onError: (String) -> Unit): LiveData<List<CastVO>> {
        val liveData = MutableLiveData<List<CastVO>>()
         liveData.postValue(getDummyCastList())
        return liveData
    }

    override fun getVideoIdByMovieId(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ) {

    }

}