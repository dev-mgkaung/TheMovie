package mk.padc.themovie.datas.vos

import androidx.room.Entity

data class PopularMovieEntityResultList(
    val results: List<PopularMovieVO>
)
@Entity(tableName = "popularmovies")
data class PopularMovieVO(
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)