package mk.padc.themovie.mvp.views

import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO

interface MainView : BaseView{

    fun displayPopularMovieList(list: List<PopularMovieVO>)
    fun displayTopRateMovieList(list: List<TopRateMovieVO>)
    fun navigateToMovieDetails(movie_id : Int)
}