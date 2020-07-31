package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.TopRateMovieVO

data class TopRateMovieResponse(
    @SerializedName("results")  val results: ArrayList<TopRateMovieVO?>? = null
)
