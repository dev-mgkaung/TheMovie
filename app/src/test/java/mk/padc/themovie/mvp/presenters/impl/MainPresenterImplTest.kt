package mk.padc.themovie.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import mk.padc.themovie.datas.dummy.getActorList
import mk.padc.themovie.datas.dummy.getDummyPopularMovieList
import mk.padc.themovie.datas.dummy.getDummyTopRelatedMovieList
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.models.impls.MockMovieModelImpl
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.mvp.views.MainView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)

@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var movieModelMock: MovieModel

    @Before
    fun setUp()
    {
        // Mocking setup
        MockKAnnotations.init(this)

        MovieModelmpl.initDatabase(ApplicationProvider.getApplicationContext())
        movieModelMock = MockMovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieImpl = this.movieModelMock

    }

    @Test
    fun onTapCart_callNavigateToMovieDetailScreen() {
        val popularvo = PopularMovieVO(1,"","Movie1","Movie Desc1",10.0,"","1/2/10","",10.0,10)
        mPresenter.onTapListItem(popularvo)
        verify {
            mView.navigateToMovieDetails(popularvo.id)
        }
    }

    @Test
    fun onUIReady_callDisplayPopularMovieList() {

        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner)

        verify {
            mView.displayPopularMovieList(getDummyPopularMovieList())
            mView.displayTopRateMovieList(getDummyTopRelatedMovieList())
            mView.displayActorList(getActorList())
        }
    }
}