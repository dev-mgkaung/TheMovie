package mk.padc.themovie.networks

import io.reactivex.Observable
import mk.padc.themovie.networks.responses.MovieListResponse
import mk.padc.themovie.utils.GET_POPULAR
import mk.padc.themovie.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.*

interface MovieApi {

    @GET(GET_POPULAR)
    fun getPopularMoveList(@Query(PARAM_ACCESS_TOKEN) apiKey : String) : Observable<MovieListResponse>

//    @GET("$MOVIE_DETAIL/{MOVIE_ID}")
//    fun getMovieDetail(@Query(PARAM_API_KEY) apiKey : String,@Path("MOVIE_ID") movieID:Int) : Observable<MovieVO>

}