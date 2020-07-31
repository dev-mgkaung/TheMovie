package mk.padc.themovie.mvp.views

import mk.padc.themovie.datas.vos.MovieDetailsVO

interface DetailView : BaseView {

    fun displayMovieDetail(moviedetail: MovieDetailsVO)
}