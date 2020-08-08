package mk.padc.themovie.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.datas.vos.GenerVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO

interface MainView : BaseView {

    fun displayPopularMovieList(list: List<PopularMovieVO>)
    fun displayTopRateMovieList(list: List<TopRateMovieVO>)
    fun displayShowCaseList(list: List<TopRateMovieVO>)
    fun displayGenericList(list: List<GenerVO>)
    fun displayActorList(list: List<ActorVO>)
    fun navigateToMovieDetails(movie_id : Int)
    fun navigateToVideo(movie_id : Int)
}