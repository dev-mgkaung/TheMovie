package mk.padc.themovie.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.PopularMovieAdapter
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.presenters.impl.MainPresenterImpl
import mk.padc.themovie.mvp.views.MainView

class MainActivity : BaseActivity() , MainView
{
    //Variable declaration
    private lateinit var mAdapter: PopularMovieAdapter
    private lateinit var mPresenter: MainPresenter
    val mMovieImpl: MovieModel = MovieModelmpl
    val popularmoviedatalist: ArrayList<PopularMovieVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpPresenter()
        setUpRecyclerView()
        setUpListeners()
        mPresenter.onUiReady(this)

    }


    private fun setUpListeners()
    {

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView() {
        mAdapter = PopularMovieAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        popular_movies_recyclerview.layoutManager = linearLayoutManager
        popular_movies_recyclerview.adapter = mAdapter
    }


    override fun displayPopularMovieList(list: List<PopularMovieVO>) {
        mAdapter.setNewData(list.toMutableList())
    }


}