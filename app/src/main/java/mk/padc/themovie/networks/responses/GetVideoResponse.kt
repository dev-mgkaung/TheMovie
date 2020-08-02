package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.VideoVO

data class GetVideoResponse(
    @SerializedName("results")  val results: ArrayList<VideoVO?>? = null
)
