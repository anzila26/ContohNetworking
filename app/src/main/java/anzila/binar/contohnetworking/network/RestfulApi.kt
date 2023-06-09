package anzila.binar.contohnetworking.network

import anzila.binar.contohnetworking.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponDataNewsItem>>

    @POST("news")
    fun postDataNews(@Body request : DataNews) : Call<ResponAddNews>

    @PUT("news/{id}")
    fun updateDataNews(
        @Path("id") id :Int,
        @Body request: DataNews
    ) : Call<List<ResponUpdateNews>>

    @GET("news/{id}")
    fun getDetailNews(
        @Path("id") id :Int
    ) : Call<List<ResponDataNewsItem>>

    @DELETE("news/{id}")
    fun deleteNews(
        @Path("id") id : Int
    ) : Call<Int>

    @GET("film")
    fun getAllFilm(): Call<List<ResponDataFilmItem>>
}