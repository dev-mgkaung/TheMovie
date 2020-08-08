package mk.padc.themovie.mvp.presenters.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.mvp.presenters.DetailPresenter
import mk.padc.themovie.mvp.views.DetailView
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.padc.themovie.datas.models.MovieModel

class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner,movie_id: Int) {

        mMovieImpl.getAllCrewAndCastFromApiAndSaveToDatabase(
            movie_id,
            onSuccess = {
            },
            onError = {
                Log.e("eror dat",it)
            }
        )

        mMovieImpl.getMovieDetailFromApiAndSaveToDatabase(
           movie_id,
            onSuccess = {},
            onError = {

            }
        )


        mMovieImpl.getMovieDetailById(
            movie_id,
            onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieDetail(it)
                }

            })

        mMovieImpl.getAllCastAndCrewList (
            movie_id,
            onError = {
                Log.e("display eror dat",it)
            })
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayCastCrewList(it)
                }

            })

    }



    override fun onTap() {

    }


}