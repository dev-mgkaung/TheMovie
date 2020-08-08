package mk.padc.themovie.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.padc.themovie.mvp.views.VideosView

interface VideoPresenter : BasePresenter<VideosView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, movieid: Int)
}
