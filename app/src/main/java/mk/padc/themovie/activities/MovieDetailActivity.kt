package mk.padc.themovie.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.about_flim.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.detail_action_bar.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.ActorAdapter
import mk.padc.themovie.adapters.CastAdapter
import mk.padc.themovie.adapters.CrewAdapter
import mk.padc.themovie.adapters.PopularMovieAdapter
import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.datas.vos.CrewVO
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.mvp.presenters.DetailPresenter
import mk.padc.themovie.mvp.presenters.impl.DetailPresenterImpl
import mk.padc.themovie.mvp.views.DetailView
import mk.padc.themovie.utils.BASE_IMAGE_URL

class MovieDetailActivity : BaseActivity() , DetailView{

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: MainActivity, mId: Int): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter
    //adapters
    private lateinit var castAdapter: CastAdapter
    private lateinit var crewAdapter: CrewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movie_id = intent.getIntExtra(movieid, 0)
        setUpPresenter()
        setUpRecyclerView()
        setUpListener()
        mPresenter.onUiReady(this,movie_id)

    }
    private fun setUpListener()
    {
        back.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
    private fun setUpRecyclerView() {
        castAdapter = CastAdapter(mPresenter)
        val alinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cast_recyclerview.layoutManager = alinearLayoutManager
        cast_recyclerview.adapter = castAdapter

        crewAdapter = CrewAdapter(mPresenter)
        val blinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        crew_recyclerview.layoutManager = blinearLayoutManager
        crew_recyclerview.adapter = crewAdapter
    }

        private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    override fun displayMovieDetail(moviedetail: MovieDetailsVO) {
        original_flim.text=moviedetail.original_title
        description.text =moviedetail.overview
        production.text= moviedetail.tagline

        Glide.with(movie_poster_image)
            .load(("$BASE_IMAGE_URL${moviedetail.poster_path}"))
            .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
            .into(movie_poster_image)
            movietitle.text=moviedetail.original_title
            overview.text= moviedetail.overview
    }

    override fun displayCrewList(list: List<CrewVO>) {
        crewAdapter.setNewData(list.toMutableList())
    }

    override fun displayCastList(list: List<CastVO>) {
        castAdapter.setNewData(list.toMutableList())
    }
}
