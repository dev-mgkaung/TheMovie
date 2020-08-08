package mk.padc.themovie.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.popular_item_movie.view.*
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.DiscoverVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.utils.BASE_IMAGE_URL

class DiscoverViewHolder(itemView: View, private val mDelegate: PopularMovieListActionDelegate)
    : BaseViewHolder<DiscoverVO>(itemView) {

    init {
        itemView.popular_item_movie_img.setOnClickListener {
            mData?.let {
                mDelegate.onTapDiscoverListItem(it)
            }
        }
    }

    override fun bindData(data: DiscoverVO) {
        mData=data
        itemView.popular_item_movie_title.text = data.original_title
        Log.d("image path=","$BASE_IMAGE_URL${data.poster_path}")
        Glide.with(itemView.popular_item_movie_img)
            .load(("$BASE_IMAGE_URL${data.poster_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(itemView.popular_item_movie_img)
    }
}