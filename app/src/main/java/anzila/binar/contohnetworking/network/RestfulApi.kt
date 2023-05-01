package anzila.binar.contohnetworking.network

import anzila.binar.contohnetworking.model.ResponDataFilmItem
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponDataNewsItem>>

    @GET("film")
    fun getAllFilm(): Call<List<ResponDataFilmItem>>
}