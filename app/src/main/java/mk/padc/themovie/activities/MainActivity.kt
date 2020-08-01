package mk.padc.themovie.activities

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.tab_layout_viewpager.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.*
import mk.padc.themovie.datas.vos.ActorVO
import mk.padc.themovie.datas.vos.GenerVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.presenters.impl.MainPresenterImpl
import mk.padc.themovie.mvp.views.MainView

class MainActivity : BaseActivity() , MainView
{
    //adapters
    private lateinit var mAdapter: PopularMovieAdapter
    private lateinit var actorAdapter: ActorAdapter
    private lateinit var showcaseAdapter: ShowCaseAdapter
    private lateinit var dynamicPagerAdapter: DynamicPagerAdapter
    //presenters
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
        val alinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        popular_movies_recyclerview.layoutManager = alinearLayoutManager
        popular_movies_recyclerview.adapter = mAdapter

        actorAdapter = ActorAdapter(mPresenter)
        val blinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        actors_recyclerview.layoutManager = blinearLayoutManager
        actors_recyclerview.adapter = actorAdapter

        showcaseAdapter = ShowCaseAdapter(mPresenter)
        val clinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        showcase_recyclerview.layoutManager = clinearLayoutManager
        showcase_recyclerview.adapter = showcaseAdapter

    }


    override fun displayPopularMovieList(list: List<PopularMovieVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun displayTopRateMovieList(list: List<TopRateMovieVO>) {
        slider_pager.adapter=SliderPagerAdapter(applicationContext,list)
        indicator.setupWithViewPager(slider_pager,true);
    }

    override fun displayShowCaseList(list: List<TopRateMovieVO>) {
        showcaseAdapter.setNewData(list.toMutableList())
    }

    override fun displayGenericList(list: List<GenerVO>) {
        Log.e("Generic data=${list.get(0).name}","fff")
        dynamicPagerAdapter= DynamicPagerAdapter(list,supportFragmentManager)
        pager.adapter= dynamicPagerAdapter
        tabs.setupWithViewPager(pager)
    }

    override fun displayActorList(list: List<ActorVO>) {
        actorAdapter.setNewData(list.toMutableList())
    }


}
