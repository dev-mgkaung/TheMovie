package mk.padc.themovie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, PopularMovieListActionDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}
