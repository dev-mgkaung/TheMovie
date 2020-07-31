package mk.padc.themovie.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import mk.padc.themovie.R
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.PopularMovieVO

class MovieDetailActivity : BaseActivity() {

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: Context, mId : Int): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }

    private var mMovieModel : MovieModelmpl = MovieModelmpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val newsId = intent.getIntExtra(movieid, 0)
//        mMovieModel.get(newsId)
//            .observe(this, Observer {
//                bindData(it)
//            })
    }

    private fun bindData(news : PopularMovieVO){
        //tvNewsHeadLine.text = news.title

//        Glide.with(this)
//            .load(news.heroImage)
//            .into(ivNewsImage)
    }
}
