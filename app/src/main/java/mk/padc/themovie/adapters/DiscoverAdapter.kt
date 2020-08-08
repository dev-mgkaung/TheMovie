package mk.padc.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.DiscoverVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.views.viewholders.DiscoverViewHolder

class DiscoverAdapter(private val mDelegate: PopularMovieListActionDelegate) : BaseRecyclerAdapter<DiscoverViewHolder, DiscoverVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_item_movie,parent,false)

        return DiscoverViewHolder(view, mDelegate)
    }
}