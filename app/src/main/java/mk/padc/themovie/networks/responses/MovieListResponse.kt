package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.PopularMovieVO

data class MovieListResponse(
    @SerializedName("code") val code : Int  = 0,
    @SerializedName("message") val message : String = "",
    @SerializedName("data") val data: ArrayList<PopularMovieVO>? = null
){
    fun isResponseOk() = (code == 200) && (data != null)
}