package mk.padc.themovie.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.datas.vos.DiscoverVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.mvp.presenters.DiscoverPrsenter
import mk.padc.themovie.mvp.views.MovieView

class DiscoverPresenterImpl : DiscoverPrsenter, BaseAppPresenterImpl<MovieView>() {

    var mMovieImpl = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, mname: String) {

        mMovieImpl.getAllDiscoverListFromApiAndSaveToDatabase(
            genericId = mname,
            onSuccess = {},
            onError = {}
        )

        mMovieImpl.getAllDiscoverList(
            mname,
            onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieList(it)
                }

            })
    }

    override fun onTapListItem(entity: PopularMovieVO) {

    }

    override fun onTapActorItem(entity: ActorVO) {

    }

    override fun onTapDiscoverListItem(entity: DiscoverVO) {

    }

    override fun onTapShowCaseItem(entity: TopRateMovieVO) {

    }


}