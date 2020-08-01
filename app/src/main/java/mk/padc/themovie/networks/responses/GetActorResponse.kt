package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.ActorVO

data class GetActorResponse(
    @SerializedName("results")  val results: ArrayList<ActorVO?>? = null
)
