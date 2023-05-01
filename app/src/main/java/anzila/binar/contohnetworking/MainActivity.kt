package anzila.binar.contohnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.contohnetworking.databinding.ActivityMainBinding
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import anzila.binar.contohnetworking.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataNews()
    }

    fun getDataNews(){
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponDataNewsItem>> {
            override fun onResponse(
                call: Call<List<ResponDataNewsItem>>,
                response: Response<List<ResponDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
                    binding.rvNews.adapter = NewsAdapter(response.body()!!)
                    //show data
                } else {
                    Toast.makeText(this@MainActivity, "Failed load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "", Toast.LENGTH_SHORT).show()
            }
        })
    }
}