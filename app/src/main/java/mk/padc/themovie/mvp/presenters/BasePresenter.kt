package mk.padc.themovie.mvp.presenters

import mk.padc.themovie.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}