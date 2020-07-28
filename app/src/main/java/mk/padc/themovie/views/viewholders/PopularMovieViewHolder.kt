package mk.padc.themovie.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.popular_item_movie.view.*
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate

class PopularMovieViewHolder(itemView: View, private val mDelegate: PopularMovieListActionDelegate)
    : BaseViewHolder<PopularMovieVO>(itemView) {

    init {
        itemView.popular_item_movie_img.setOnClickListener {
            mData?.let {
                mDelegate.onTapListItem(it)
            }
        }
    }

    override fun bindData(data: PopularMovieVO) {
        mData = data

        itemView.popular_item_movie_title.text = data.original_title

        Glide.with(itemView.popular_item_movie_img)
            .load(data.poster_path)
            .into(itemView.popular_item_movie_img)
    }
}