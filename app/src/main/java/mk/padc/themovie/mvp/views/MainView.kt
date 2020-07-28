package mk.padc.themovie.mvp.views

import mk.padc.themovie.datas.vos.PopularMovieVO

interface MainView : BaseView{

    fun displayPopularMovieList(list: List<PopularMovieVO>)

}