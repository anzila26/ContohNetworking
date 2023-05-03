package anzila.binar.contohnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import anzila.binar.contohnetworking.databinding.ActivityDetailNewsBinding
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import anzila.binar.contohnetworking.viewmodel.NewsViewModel

class DetailNewsActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailNewsBinding
    lateinit var dataNews : ResponDataNewsItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bun = intent.extras
        var idd = bun!!.getInt("detailnews")
        Log.d("idd", idd.toString())
        getDetailNews(idd)
    }

    fun getDetailNews(id : Int) {
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.callDetailApiNews(id)
        viewModel.getliveDataNews().observe(this, Observer {

        })
    }
}