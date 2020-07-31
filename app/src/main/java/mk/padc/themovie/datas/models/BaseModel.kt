package mk.padc.themovie.datas.models

import android.content.Context
import mk.padc.themovie.networks.MovieApi
import mk.padc.themovie.persistance.MoviesDB
import mk.padc.themovie.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel  {

    protected var mApi: MovieApi
    protected lateinit var mTheDB: MoviesDB


    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mApi = retrofit.create(MovieApi::class.java)
    }


    fun initDatabase(context: Context) {
        mTheDB = MoviesDB.getDBInstance(context)
    }

}