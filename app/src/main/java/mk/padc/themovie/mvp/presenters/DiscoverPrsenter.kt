package mk.padc.themovie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.mvp.views.MovieView

interface DiscoverPrsenter : BasePresenter<MovieView>, PopularMovieListActionDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, genericid: String)
}
