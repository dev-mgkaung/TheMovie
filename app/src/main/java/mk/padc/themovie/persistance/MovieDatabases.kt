package mk.padc.themovie.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mk.padc.themovie.datas.vos.*
import mk.padc.themovie.persistance.daos.MoviesDao

@Database(entities = [PopularMovieVO::class,TopRateMovieVO::class, MovieDetailsVO::class, ActorVO::class ,
    GenerVO::class,DiscoverVO::class,CastCrewVO::class], version = 8, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "THEMOVIES.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java,
                        DB_NAME
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun moviesDao(): MoviesDao
}