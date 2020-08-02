package mk.padc.themovie.persistance

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.padc.themovie.datas.vos.CrewVO

class CrewTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<CrewVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CrewVO>{
        val countryListType = object : TypeToken<ArrayList<CrewVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}