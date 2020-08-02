package mk.padc.themovie.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import mk.padc.themovie.datas.vos.*

@Dao
interface MoviesDao {

    @Query("select * from popularmovies")
    fun getAllPopularMovies(): LiveData<List<PopularMovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovieData(popularmovies: List<PopularMovieVO?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieData(popularmovies: PopularMovieVO)

    @Query("SELECT * FROM popularmovies WHERE id = :id")
    fun findPopularMovieById(id : Int) : LiveData<PopularMovieVO>

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

    @Query("select * from castcrew where  sid=:movie_id")
    fun getAllCastAndCrewList(movie_id: Int): LiveData<CastCrewVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCastCrewData(generic: CastCrewVO) :Int

}