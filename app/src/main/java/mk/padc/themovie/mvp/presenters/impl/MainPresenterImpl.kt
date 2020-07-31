package mk.padc.themovie.mvp.presenters.impl
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mMovieImpl = MovieModelmpl

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
    }

    override fun onTapListItem(entity: PopularMovieVO) {

        mView?.navigateToMovieDetails(entity.id)
    }


}