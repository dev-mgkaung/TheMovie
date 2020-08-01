package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.DiscoverVO

data class GetDiscoverResponse(
    @SerializedName("results")  val results: ArrayList<DiscoverVO?>? = null
)
