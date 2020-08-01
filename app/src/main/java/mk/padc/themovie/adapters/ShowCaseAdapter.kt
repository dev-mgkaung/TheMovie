package mk.padc.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.views.viewholders.ShowCaseViewHolder

class ShowCaseAdapter(private val mDelegate: PopularMovieListActionDelegate) : BaseRecyclerAdapter<ShowCaseViewHolder, TopRateMovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_case_item_layout,parent,false)

        return ShowCaseViewHolder(view, mDelegate)
    }
}