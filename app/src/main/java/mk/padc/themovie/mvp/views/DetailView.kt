package mk.padc.themovie.mvp.views

import mk.padc.themovie.datas.vos.CastCrewVO
import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.datas.vos.CrewVO
import mk.padc.themovie.datas.vos.MovieDetailsVO

interface DetailView : BaseView {
    fun displayMovieDetail(moviedetail: MovieDetailsVO)
    fun displayCastCrewList(list: CastCrewVO)
}