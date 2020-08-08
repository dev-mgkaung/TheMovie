package mk.padc.themovie.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.show_case_item_layout.view.*
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.utils.BASE_IMAGE_URL

class ShowCaseViewHolder(itemView: View, private val mDelegate: PopularMovieListActionDelegate)
    : BaseViewHolder<TopRateMovieVO>(itemView) {

    init {
        itemView.show_case_image.setOnClickListener {
            mData?.let {
                mDelegate.onTapShowCaseItem(it)
            }
        }
    }

    override fun bindData(data: TopRateMovieVO) {
        mData=data
        itemView.showcasename.text = data.original_title
        itemView.show_case_title.text=data.release_date
        Log.d("image path=","$BASE_IMAGE_URL${data.poster_path}")
        Glide.with(itemView.show_case_image)
            .load(("$BASE_IMAGE_URL${data.poster_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(itemView.show_case_image)
    }
}