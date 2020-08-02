package mk.padc.themovie.mvp.presenters.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import mk.padc.themovie.datas.dummy.*
import mk.padc.themovie.datas.models.MovieModel
import mk.padc.themovie.datas.models.impls.MockMovieModelImpl
import mk.padc.themovie.datas.models.impls.MovieModelmpl
import mk.padc.themovie.mvp.views.DetailView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)

@Config(manifest = Config.NONE)
class DetailPresenterImplTest {

    private lateinit var mPresenter : DetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailView

    private lateinit var movieModelMock: MovieModel

    @Before
    fun setUp()
    {
        // Mocking setup
        MockKAnnotations.init(this)

        MovieModelmpl.initDatabase(ApplicationProvider.getApplicationContext())
        movieModelMock = MockMovieModelImpl

        mPresenter = DetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieImpl = this.movieModelMock

    }

    @Test
    fun onUIReady_callDisplayPopularMovieList() {

        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner,1)

        verify {
            mView.displayCastList(getDummyCastList())
            mView.displayCrewList(getDummyCrewList())
        }
    }
}