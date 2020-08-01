package mk.padc.themovie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.movie_list_recyclerview.*
import kotlinx.android.synthetic.main.movie_list_recyclerview.view.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.DiscoverAdapter
import mk.padc.themovie.adapters.PopularMovieAdapter
import mk.padc.themovie.datas.vos.*
import mk.padc.themovie.mvp.presenters.DiscoverPrsenter
import mk.padc.themovie.mvp.presenters.MainPresenter
import mk.padc.themovie.mvp.presenters.impl.DiscoverPresenterImpl
import mk.padc.themovie.mvp.presenters.impl.MainPresenterImpl
import mk.padc.themovie.mvp.views.MainView
import mk.padc.themovie.mvp.views.MovieView

private const val ARG_PARAM1 = "movie_id"
class MovieFragment : Fragment(), MovieView {
    private var movie_id: Int? = null
    private lateinit var mAdapter: DiscoverAdapter
    private lateinit var mPresenter: DiscoverPrsenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie_id = it.getInt(ARG_PARAM1)
        }
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this,movie_id.toString())
    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DiscoverPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = DiscoverAdapter(mPresenter)
        val alinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        fragmentmovies_recyclerview?.layoutManager = alinearLayoutManager
        fragmentmovies_recyclerview?.adapter = mAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_list_recyclerview, container, false)

    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(movie_id: Int) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, movie_id)
                }
            }
    }

    override fun displayMovieList(list: List<DiscoverVO>) {
        mAdapter.setNewData(list.toMutableList())
    }



}