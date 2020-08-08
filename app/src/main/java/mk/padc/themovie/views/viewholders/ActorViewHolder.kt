package mk.padc.themovie.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.actor_list_item_layout.view.*
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.delegates.PopularMovieListActionDelegate
import mk.padc.themovie.utils.BASE_IMAGE_URL


class ActorViewHolder(itemView: View, private val mDelegate: PopularMovieListActionDelegate)
    : BaseViewHolder<ActorVO>(itemView) {

    init {
        itemView.profile_image.setOnClickListener {
            mData?.let {
                mDelegate.onTapActorItem(it)
            }
        }
    }

    override fun bindData(data: ActorVO) {
        mData=data
        itemView.actorname.text = data.name
        itemView.likecount.text = "You Like ${data.popularity} Movies"
        Glide.with(itemView.profile_image)
            .load(("$BASE_IMAGE_URL${data.profile_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(itemView.profile_image)
    }
}