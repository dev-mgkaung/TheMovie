package mk.padc.themovie.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "actors")
data class ActorVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("adult")val adult: Boolean,
    @SerializedName("gender") val gender: Int,
    @SerializedName("known_for_department") val known_for_department: String,
    @SerializedName("name")val name: String,
    @SerializedName("popularity")val popularity: Double,
    @SerializedName("profile_path") val profile_path: String
)

data class KnownFor(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)