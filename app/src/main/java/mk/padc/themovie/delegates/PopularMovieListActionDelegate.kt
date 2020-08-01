package mk.padc.themovie.delegates

import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.datas.vos.DiscoverVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO

interface PopularMovieListActionDelegate {
    fun onTapListItem(entity : PopularMovieVO)
    fun onTapActorItem(entity : ActorVO)
    fun onTapDiscoverListItem(entity : DiscoverVO)
    fun onTapShowCaseItem(entity : TopRateMovieVO)
}