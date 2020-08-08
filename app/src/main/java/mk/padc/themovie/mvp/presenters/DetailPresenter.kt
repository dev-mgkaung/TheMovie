package mk.padc.themovie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.padc.themovie.delegates.MovieDetailDelegate
import mk.padc.themovie.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView>, MovieDetailDelegate {
   fun onUiReady(lifeCycleOwner: LifecycleOwner,movieid: Int)
}
