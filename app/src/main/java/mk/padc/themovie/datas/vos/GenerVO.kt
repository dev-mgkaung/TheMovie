package mk.padc.themovie.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "gener")
data class GenerVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)