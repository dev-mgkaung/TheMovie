package mk.padc.themovie.mvp.presenters.impl

import mk.padc.themovie.mvp.presenters.AbstractBasePresenter
import mk.padc.themovie.mvp.presenters.BasePresenter
import mk.padc.themovie.mvp.views.BaseView

abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
