package mk.padc.themovie.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.mvp.presenters.DetailPresenter
import mk.padc.themovie.mvp.views.DetailView
import androidx.lifecycle.Observer

class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    var mMovieImpl = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner,movie_id: Int) {

        mMovieImpl.getMovieDetailFromApiAndSaveToDatabase(
            movieId = movie_id,
            onSuccess = {},
            onError = {}
        )

        mMovieImpl.getMovieDetailById(
            movie_id,
            onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieDetail(it)
                }

            })
    }



    override fun onTap() {

    }


}