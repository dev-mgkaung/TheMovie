package mk.padc.themovie.mvp.presenters.impl

import android.widget.VideoView
import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.mvp.presenters.VideoPresenter
import mk.padc.themovie.mvp.views.VideosView

class VideoPresenterImpl : VideoPresenter, BaseAppPresenterImpl<VideosView>() {

    var mMovieImpl: MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, movie_id: Int) {
        loadAllVideoFromAPI(movie_id)
    }
    private fun loadAllVideoFromAPI(movie_id: Int) {
        mMovieImpl.getVideoIdByMovieId(
            movie_id,
            onSuccess = {
                mView?.displayVideo(videoId = it.get(0).key)
            },
            onError = {}
        )
    }
}