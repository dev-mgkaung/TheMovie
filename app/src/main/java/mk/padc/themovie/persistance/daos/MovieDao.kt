package mk.padc.themovie.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.padc.themovie.datas.vos.*

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

    @Query("select * from moviedetail where id=:movie_id")
    fun getAllMovieDetail(movie_id : Int): LiveData<MovieDetailsVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetailData(moviedetail: MovieDetailsVO) : Long

    @Query("select * from actors")
    fun getAllActorList(): LiveData<List<ActorVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActorData(toprates: List<ActorVO?>)

    @Query("select * from gener")
    fun getAllGenericList(): LiveData<List<GenerVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenerData(generic: List<GenerVO?>)

    @Query("select * from discover")
    fun getAllDiscoverList(): LiveData<List<DiscoverVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDiscoverData(generic: List<DiscoverVO?>)

    @Query("select * from crew")
    fun getAllCrewList(): LiveData<List<CrewVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCrewData(generic: List<CrewVO?>)

    @Query("select * from casttb")
    fun getAllCastList(): LiveData<List<CastVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCastData(generic: List<CastVO?>)
}