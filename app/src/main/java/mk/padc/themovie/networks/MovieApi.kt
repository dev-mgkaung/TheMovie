package mk.padc.themovie.networks

import retrofit2.http.*
import io.reactivex.Observable
import mk.padc.themovie.datas.vos.CastCrewVO
import mk.padc.themovie.datas.vos.MovieDetailsVO
import mk.padc.themovie.networks.responses.*
import mk.padc.themovie.utils.*

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

    @GET("movie/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<MovieDetailsVO>

    @GET(GET_ACTOR)
    fun getActorList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Observable<GetActorResponse>

    @GET(GET_GENERIC_List)
    fun getGenericList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<GetGenericResponse>

    @GET(GET_Discover)
    fun getDiscoverList(
        @Query("api_key") apiKey: String,
        @Query("with_genres") withGeneric: String
    ): Observable<GetDiscoverResponse>

    @GET("movie/{movie_id}/credits")
    fun getMovieDetailByActorsAndCreator(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<CastCrewVO>

    @GET("movie/{movie_id}/videos")
    fun getVideoIdByMovieId(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Observable<GetVideoResponse>

}