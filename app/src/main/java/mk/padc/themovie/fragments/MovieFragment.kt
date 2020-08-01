package mk.padc.themovie.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.movie_list_recyclerview.view.*
import mk.padc.themovie.R
import mk.padc.themovie.adapters.DiscoverAdapter
import mk.padc.themovie.datas.vos.*
import mk.padc.themovie.mvp.presenters.DiscoverPrsenter
import mk.padc.themovie.mvp.presenters.impl.DiscoverPresenterImpl
import mk.padc.themovie.mvp.views.MovieView

private const val ARG_PARAM1 = "movie_id"
class MovieFragment : Fragment(), MovieView {
    private var movie_id: Int? = null
    private lateinit var mAdapter: DiscoverAdapter
    private lateinit var mPresenter: DiscoverPrsenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

        private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DiscoverPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(view: View) {
        mAdapter = DiscoverAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        view.fragmentmovies_recyclerview.layoutManager = linearLayoutManager
        view.fragmentmovies_recyclerview.adapter = mAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view= inflater.inflate(R.layout.movie_list_recyclerview, container, false)
        arguments?.let {
            movie_id = it.getInt(ARG_PARAM1)
        }
        setUpPresenter()
        setUpRecyclerView(view)
        mPresenter.onUiReady(this,movie_id.toString())
        return view;
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
        Log.e("data arrived ${list.get(0).original_title}","ff");
        mAdapter.setNewData(list.toMutableList())
    }



}