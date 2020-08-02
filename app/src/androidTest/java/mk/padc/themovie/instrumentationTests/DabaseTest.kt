package mk.padc.themovie.instrumentationTests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import mk.padc.themovie.datas.dummy.getDummyPopularMovieList
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.persistance.MoviesDB
import mk.padc.themovie.persistance.daos.MoviesDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    // Dao and Database
    private lateinit var movieDao: MoviesDao
    private lateinit var db: MoviesDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(
            context, MoviesDB::class.java
        ).build()

        movieDao = db.moviesDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest() {
        val data1 = PopularMovieVO(1,"","Movie1","Movie Desc1",10.0,"","1/2/10","",10.0,10)
        movieDao.insertPopularMovieData(data1)
         assert(movieDao.findPopularMovieById(data1.id).value?.id == data1.id)
    }
}