package mk.padc.themovie.mvp.presenters.impl
import androidx.lifecycle.LifecycleOwner
import io.reactivex.android.schedulers.AndroidSchedulers
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mMovieImpl = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllMovieFromAPI()
        requestAllDatas(lifeCycleOwner)
    }

    private fun requestAllDatas(lifeCycleOwner: LifecycleOwner) {
//        mMovieImpl.getAllPopularMovieList(onError = {
//        }).observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mView?.displayPopularMovieList(it)
//            })
    }


    private fun loadAllMovieFromAPI() {
        mMovieImpl.getAllPopularMovieFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }
    override fun initPresenter(view: MainView) {

    }

    override fun onTapListItem(entity: PopularMovieVO) {

    }


}