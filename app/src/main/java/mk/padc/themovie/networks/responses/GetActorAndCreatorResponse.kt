package mk.padc.themovie.networks.responses

import com.google.gson.annotations.SerializedName
import mk.padc.themovie.datas.vos.CastVO
import mk.padc.themovie.datas.vos.CrewVO

data class GetActorAndCreatorResponse(
    @SerializedName("crew")  val crew: ArrayList<CrewVO?>? = null,
    @SerializedName("cast")  val cast: ArrayList<CastVO?>? = null
)