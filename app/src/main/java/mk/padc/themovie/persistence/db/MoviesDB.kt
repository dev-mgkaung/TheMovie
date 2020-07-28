package mk.padc.themovie.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mk.padc.themovie.datas.vos.PopularMovieVO

@Database(entities = [PopularMovieVO::class], version = 1, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {
    companion object {
        val DB_NAME = "THEMOVIES.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
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