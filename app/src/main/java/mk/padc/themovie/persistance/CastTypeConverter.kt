package mk.padc.themovie.persistance

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.padc.themovie.datas.vos.CastVO

class CastTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<CastVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CastVO>{
        val countryListType = object : TypeToken<ArrayList<CastVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}