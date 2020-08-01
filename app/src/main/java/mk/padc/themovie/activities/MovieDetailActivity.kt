package mk.padc.themovie.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.popular_item_movie.view.*
import mk.padc.themovie.R
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.mvp.presenters.DetailPresenter
import mk.padc.themovie.mvp.presenters.impl.DetailPresenterImpl
import mk.padc.themovie.mvp.views.DetailView
import mk.padc.themovie.utils.BASE_IMAGE_URL

class MovieDetailActivity : BaseActivity() , DetailView{

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: Context, mId : Int): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movie_id = intent.getIntExtra(movieid, 0)
        setUpPresenter()
        mPresenter.onUiReady(this,movie_id)

    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun displayMovieDetail(moviedetail: MovieDetailsVO) {

        Glide.with(movie_poster_image)
            .load(("$BASE_IMAGE_URL${moviedetail.poster_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(movie_poster_image)
            movietitle.text=moviedetail.original_title
            overview.text= moviedetail.overview
    }
}
