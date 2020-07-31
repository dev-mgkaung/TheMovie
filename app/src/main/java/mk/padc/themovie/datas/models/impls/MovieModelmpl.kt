package mk.padc.themovie.datas.models.impls

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mk.padc.themovie.datas.models.BaseModel
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO
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
                Log.d("datas="+it,"")
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                Log.e("datase=$movieId","("+it.title);
                mTheDB.moviesDao().insertMovieDetailData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }




}