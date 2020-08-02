package mk.padc.themovie.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import mk.padc.themovie.persistance.CastTypeConverter
import mk.padc.themovie.persistance.CrewTypeConverter

@Entity(tableName = "castcrew")
@TypeConverters(CastTypeConverter::class, CrewTypeConverter::class)
data class CastCrewVO
    (
    @PrimaryKey
    @SerializedName("id") var sid: Int,
    @SerializedName("crew")  var crew : ArrayList<CrewVO> = arrayListOf(),
    @SerializedName("cast")     var cast : ArrayList<CastVO> = arrayListOf()
)
{}