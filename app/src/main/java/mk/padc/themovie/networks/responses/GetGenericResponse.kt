package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.GenerVO
import mk.padc.themovie.datas.vos.PopularMovieVO

data class GetGenericResponse(
    @SerializedName("genres")  val results: ArrayList<GenerVO?>? = null
)