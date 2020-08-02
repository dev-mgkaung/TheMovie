package mk.padc.themovie.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CrewVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("credit_id") val credit_id: String,
    @SerializedName("department")val department: String,
    @SerializedName("gender") val gender: Int,
    @SerializedName("job")val job: String,
    @SerializedName("name")  val name: String,
    @SerializedName("profile_path") val profile_path: String
)