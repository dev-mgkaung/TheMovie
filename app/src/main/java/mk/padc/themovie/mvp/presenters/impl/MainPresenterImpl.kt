package mk.padc.themovie.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.datas.vos.DiscoverVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllMoviesFromAPI()
        onNotifyCallMovieList(lifeCycleOwner)
    }


    private fun onNotifyCallMovieList(lifeCycleOwner: LifecycleOwner)
    {
        mMovieImpl.getAllPopularMovieList(onError = {})
            .observe(lifeCycleOwner, Observer {
            mView?.displayPopularMovieList(it)
        })

        mMovieImpl.getAllTopRatedMovieList (onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayTopRateMovieList(it)
                mView?.displayShowCaseList(it)
            })

        mMovieImpl.getAllActorList (onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayActorList(it)
            })

        mMovieImpl.getAllGenericList  (onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayGenericList(it)
            })
    }

    private fun loadAllMoviesFromAPI() {
        mMovieImpl.getAllPopularMovieFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
        mMovieImpl.getAllTopRatedMovieListFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
        mMovieImpl.getAllActorListFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
        mMovieImpl.getAllGenericListFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }

    override fun onTapListItem(entity: PopularMovieVO) {
        mView?.navigateToMovieDetails(entity.id)
    }

    override fun onTapActorItem(entity: ActorVO) {

    }

    override fun onTapDiscoverListItem(entity: DiscoverVO) {
        mView?.navigateToMovieDetails(entity.id)
    }

    override fun onTapShowCaseItem(entity: TopRateMovieVO) {
        mView?.navigateToMovieDetails(entity.id)
    }


}