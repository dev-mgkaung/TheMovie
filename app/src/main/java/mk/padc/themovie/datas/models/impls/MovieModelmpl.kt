package mk.padc.themovie.datas.models.impls

import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mk.padc.themovie.datas.models.BaseModel
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.utils.EM_NO_INTERNET_CONNECTION
import mk.padc.themovie.utils.PARAM_ACCESS_TOKEN

object MovieModelmpl : MovieModel, BaseModel() {

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.moviesDao().getAllPopularMovies()
    }

    override fun getAllPopularMovieFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi
            .getPopularMoveList(PARAM_ACCESS_TOKEN)
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.moviesDao().insertAllPopularMovieData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
      }

}