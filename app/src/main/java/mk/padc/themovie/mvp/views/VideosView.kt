package mk.padc.themovie.mvp.views

import mk.padc.share.mvp.views.BaseView


interface VideosView : BaseView {

    fun displayVideo(videoId: String)

}