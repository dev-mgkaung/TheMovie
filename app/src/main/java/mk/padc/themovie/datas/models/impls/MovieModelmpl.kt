package mk.padc.themovie.datas.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mk.padc.themovie.datas.models.BaseModel
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.vos.*
import mk.padc.themovie.utils.EM_NO_INTERNET_CONNECTION
import mk.padc.themovie.utils.LANGUAGE
import mk.padc.themovie.utils.PARAM_API_ACCESS_TOKEN
import mk.padc.themovie.utils.page_id

object MovieModelmpl : MovieModel, BaseModel() {

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.moviesDao()
            .getAllPopularMovies()
    }

    @SuppressLint("CheckResult")
    override fun getAllPopularMovieFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getPopularMovies(PARAM_API_ACCESS_TOKEN, LANGUAGE, page_id)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertAllPopularMovieData(it)
            },{
               onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllTopRatedMovieList(onError: (String) -> Unit): LiveData<List<TopRateMovieVO>> {
        return mTheDB.moviesDao()
            .getAllTopRatedMovies()
    }

    @SuppressLint("CheckResult")
    override fun getAllTopRatedMovieListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getTopRatedMovies(PARAM_API_ACCESS_TOKEN)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertAllTopRatedMovieData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getMovieDetailById(smovieId: Int,onError: (String) -> Unit): LiveData<MovieDetailsVO> {
        return mTheDB.moviesDao()
            .getAllMovieDetail(movie_id = smovieId)

    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getMovieDetailById(movieId,PARAM_API_ACCESS_TOKEN)
            .map { it?.let { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertMovieDetailData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllActorList(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.moviesDao().getAllActorList()
    }
    @SuppressLint("CheckResult")
    override fun getAllActorListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getActorList(PARAM_API_ACCESS_TOKEN, LANGUAGE, page_id)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertActorData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getAllGenericListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getGenericList(PARAM_API_ACCESS_TOKEN, LANGUAGE)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertGenerData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }
    @SuppressLint("CheckResult")
    override fun getAllDiscoverListFromApi(
        genericname: String,
        onSuccess: (List<DiscoverVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getDiscoverList(PARAM_API_ACCESS_TOKEN,  genericname)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
               onSuccess(it as List<DiscoverVO>)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllGenericList(onError: (String) -> Unit): LiveData<List<GenerVO>> {
        return mTheDB.moviesDao()
            .getAllGenericList()
    }





    @SuppressLint("CheckResult")
    override fun getAllCrewAndCastFromApiAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.getMovieDetailByActorsAndCreator(movieId,PARAM_API_ACCESS_TOKEN)
            .map{it}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertCastCrewData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }



    override fun getAllCastAndCrewList(id: Int,onError: (String) -> Unit): LiveData<CastCrewVO> {
        return mTheDB.moviesDao()
            .getAllCastAndCrewList(movie_id = id)
    }


    @SuppressLint("CheckResult")
    override fun getVideoIdByMovieId(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ){
        mApi.getVideoIdByMovieId(movieId,PARAM_API_ACCESS_TOKEN)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
             it.let {
                 onSuccess(it as List<VideoVO>)
             }
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }
}