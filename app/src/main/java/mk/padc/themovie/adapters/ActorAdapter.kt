package mk.padc.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.views.viewholders.ActorViewHolder

class ActorAdapter(private val mDelegate: PopularMovieListActionDelegate) : BaseRecyclerAdapter<ActorViewHolder, ActorVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_list_item_layout,parent,false)
        return ActorViewHolder(view, mDelegate)
    }
}