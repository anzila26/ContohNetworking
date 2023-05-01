package anzila.binar.contohnetworking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.contohnetworking.databinding.ItemNewsBinding
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import com.bumptech.glide.Glide

class NewsAdapter(var listNews : List<ResponDataNewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgNews)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}