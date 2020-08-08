package mk.padc.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.CrewVO
import mk.padc.themovie.delegates.MovieDetailDelegate
import mk.padc.themovie.views.viewholders.CrewViewHolder

class CrewAdapter(private val mDelegate: MovieDetailDelegate) : BaseRecyclerAdapter<CrewViewHolder, CrewVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_list_item_layout,parent,false)

        return CrewViewHolder(view,mDelegate)
    }
}