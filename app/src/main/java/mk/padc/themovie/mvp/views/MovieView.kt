package mk.padc.themovie.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.padc.themovie.datas.vos.DiscoverVO

interface MovieView : BaseView {

    fun displayMovieList(list: List<DiscoverVO>)
    fun navigateToDetail(id: Int)
}