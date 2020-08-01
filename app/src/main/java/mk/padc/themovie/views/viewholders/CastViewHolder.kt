package mk.padc.themovie.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.actor_list_item_layout.view.*
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.delegates.MovieDetailDelegate
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.utils.BASE_IMAGE_URL

class CastViewHolder(itemView: View, private val mDelegate: MovieDetailDelegate)
    : BaseViewHolder<CastVO>(itemView) {

    init { }

    override fun bindData(data: CastVO) {
        mData=data
        itemView.actorname.text = data.name
        itemView.likecount.text = "You Like 3 Movies"
        Glide.with(itemView.profile_image)
            .load(("$BASE_IMAGE_URL${data.profile_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(itemView.profile_image)
    }
}