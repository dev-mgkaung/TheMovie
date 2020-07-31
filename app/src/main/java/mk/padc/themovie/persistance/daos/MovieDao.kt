package mk.padc.themovie.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.datas.vos.PopularMovieVO
import mk.padc.themovie.datas.vos.TopRateMovieVO

@Dao
interface MoviesDao {

    @Query("select * from popularmovies")
    fun getAllPopularMovies(): LiveData<List<PopularMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovieData(popularmovies: List<PopularMovieVO?>)

    @Query("select * from topratedmovies")
    fun getAllTopRatedMovies(): LiveData<List<TopRateMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTopRatedMovieData(toprates: List<TopRateMovieVO?>)

    @Query("select * from moviedetail")
    fun getAllMovieDetail(): LiveData<List<MovieDetailsVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailData(moviedetail: List<MovieDetailsVO?>)
}