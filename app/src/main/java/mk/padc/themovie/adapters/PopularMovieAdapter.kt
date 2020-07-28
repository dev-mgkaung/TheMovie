package mk.padc.themovie.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.views.viewholders.PopularMovieViewHolder

class PopularMovieAdapter(private val mDelegate: PopularMovieListActionDelegate) : BaseRecyclerAdapter<PopularMovieViewHolder, PopularMovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_item_movie,parent,false)

        return PopularMovieViewHolder(view, mDelegate)
    }
}