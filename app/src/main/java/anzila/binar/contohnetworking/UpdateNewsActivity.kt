package anzila.binar.contohnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import anzila.binar.contohnetworking.databinding.ActivityUpdateNewsBinding
import anzila.binar.contohnetworking.viewmodel.NewsViewModel

class UpdateNewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var id = intent.getStringExtra("update")
            var title = binding.upTitle.text.toString()
            var author = binding.upAuthor.text.toString()
            var img = binding.upImage.text.toString()
            var desc = binding.upDescription.toString()
            updateDataNews(id!!.toInt(), title, img, author, desc)
        }
    }

    fun updateDataNews(id: Int, title: String, image: String, author: String, desc: String) {
        var viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.callUpdDataNews(id, title, image, author, desc)
        viewModel.putNews().observe(this) {
            if (it != null) {
            }
        }
    }
}