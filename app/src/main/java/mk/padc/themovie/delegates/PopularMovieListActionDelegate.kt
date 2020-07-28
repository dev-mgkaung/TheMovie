package mk.padc.themovie.delegates

import mk.padc.themovie.datas.vos.PopularMovieVO

interface PopularMovieListActionDelegate {
    fun onTapListItem(entity : PopularMovieVO)
}