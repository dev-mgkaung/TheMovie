package mk.padc.themovie.networks

import mk.padc.themovie.networks.responses.MovieListResponse
import mk.padc.themovie.utils.GET_POPULAR
import retrofit2.http.*
import io.reactivex.Observable
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.networks.responses.TopRateMovieResponse
import mk.padc.themovie.utils.GET_TOPRATED

interface MovieApi {

    @GET(GET_POPULAR)
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Observable<MovieListResponse>

    @GET(GET_TOPRATED)
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String
    ): Observable<TopRateMovieResponse>

    @GET("{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String

    ): Observable<MovieDetailsVO>

}