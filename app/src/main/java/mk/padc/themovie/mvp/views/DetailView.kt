package mk.padc.themovie.mvp.views

import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.datas.vos.CrewVO
import mk.padc.themovie.datas.vos.MovieDetailsVO

interface DetailView : BaseView {
    fun displayMovieDetail(moviedetail: MovieDetailsVO)
    fun displayCrewList(list: List<CrewVO>)
    fun displayCastList(list: List<CastVO>)
}