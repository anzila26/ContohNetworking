package anzila.binar.contohnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.contohnetworking.databinding.ActivityMainFilmBinding
import anzila.binar.contohnetworking.model.ResponDataFilmItem
import anzila.binar.contohnetworking.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityFilm : AppCompatActivity() {

    lateinit var binding : ActivityMainFilmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFilm()
    }

    fun getDataFilm(){
        RetrofitClient.instance.getAllFilm().enqueue(object : Callback<List<ResponDataFilmItem>> {
            override fun onResponse(
                call: Call<List<ResponDataFilmItem>>,
                response: Response<List<ResponDataFilmItem>>
            ) {
                if (response.isSuccessful) {
                    binding.rvFilm.layoutManager = LinearLayoutManager(this@MainActivityFilm, LinearLayoutManager.VERTICAL,false)
                    binding.rvFilm.adapter = FilmAdapter(response.body()!!)
                    //show data
                } else {
                    Toast.makeText(this@MainActivityFilm, "Failed load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponDataFilmItem>>, t: Throwable) {
                Toast.makeText(this@MainActivityFilm, "", Toast.LENGTH_SHORT).show()
            }
        })
    }
}