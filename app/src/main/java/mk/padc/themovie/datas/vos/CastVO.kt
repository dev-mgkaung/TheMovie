package mk.padc.themovie.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "casttb")
data class CastVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("cast_id")  val cast_id: Int,
    @SerializedName("character")   val character: String,
    @SerializedName("credit_id")  val credit_id: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("name")  val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("profile_path") val profile_path: String?
)