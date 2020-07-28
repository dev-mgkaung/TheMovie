package mk.padc.themovie.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import mk.padc.themovie.datas.vos.PopularMovieVO

@Dao
interface MoviesDao {

    @Query("select * from popularmovies")
    fun getAllPopularMovies(): LiveData<List<PopularMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovieData(infos:List<PopularMovieVO>)
}