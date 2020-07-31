package mk.padc.themovie.networks.responses
import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.PopularMovieVO

data class MovieListResponse(
    @SerializedName("results")  val results: ArrayList<PopularMovieVO?>? = null
)
