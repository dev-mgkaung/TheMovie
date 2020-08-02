package mk.padc.themovie

import android.app.Application
import mk.padc.themovie.datas.models.impls.MovieModelmpl

class MyApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        MovieModelmpl.initDatabase(applicationContext)
    }
}