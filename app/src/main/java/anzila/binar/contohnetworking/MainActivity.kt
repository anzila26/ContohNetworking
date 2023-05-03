package anzila.binar.contohnetworking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import anzila.binar.contohnetworking.databinding.ActivityMainBinding
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import anzila.binar.contohnetworking.network.RetrofitClient
import anzila.binar.contohnetworking.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataNews()

        binding.addButton.setOnClickListener {
            startActivity(Intent(this, AddNewsActivity::class.java))
        }
    }

    fun showDataNews() {
        val viewModelNews = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.getliveDataNews().observe(this, Observer {
            newsAdapter = NewsAdapter(it)
            if (it != null) {
                binding.rvNews.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvNews.adapter = NewsAdapter(it)
            }

            newsAdapter.onDetail = {
                var detail = Intent(this, DetailNewsActivity::class.java)
                detail.putExtra("det", it)
                startActivity(detail)
            }
        })
    }
}
