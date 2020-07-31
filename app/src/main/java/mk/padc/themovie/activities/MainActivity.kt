package mk.padc.themovie.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.PopularMovieAdapter
import mk.padc.themovie.adapters.SliderPagerAdapter
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.presenters.impl.MainPresenterImpl
import mk.padc.themovie.mvp.views.MainView

class MainActivity : BaseActivity() , MainView
{
    //Variable declaration
    private lateinit var mAdapter: PopularMovieAdapter


    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }


    override fun navigateToMovieDetails(mvoid_id: Int) {

        startActivity(MovieDetailActivity.newItent(this, mvoid_id))
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView() {
        mAdapter = PopularMovieAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popular_movies_recyclerview.layoutManager = linearLayoutManager
        popular_movies_recyclerview.adapter = mAdapter
    }


    override fun displayPopularMovieList(list: List<PopularMovieVO>) {
        mAdapter.setNewData(list.toMutableList())

    }

    override fun displayTopRateMovieList(list: List<TopRateMovieVO>) {
        slider_pager.adapter=SliderPagerAdapter(applicationContext,list)
        indicator.setupWithViewPager(slider_pager,true);
    }


}
