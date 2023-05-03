package anzila.binar.contohnetworking

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import anzila.binar.contohnetworking.databinding.ItemNewsBinding
import anzila.binar.contohnetworking.model.ResponDataNewsItem
import com.bumptech.glide.Glide

class NewsAdapter(var listNews : List<ResponDataNewsItem>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var onDetail : ((ResponDataNewsItem)->Unit)? = null

    class ViewHolder(var binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgNews)

        holder.binding.btnUpdate.setOnClickListener {
            var edit = Intent(it.context, UpdateNewsActivity::class.java)
            edit.putExtra("update", listNews[position].id)
            it.context.startActivity(edit)
        }

        holder.binding.btnDelete.setOnClickListener(object  : View.OnClickListener {
            override fun onClick(v: View?) {
                val bun = Bundle()
                bun.putString("id", listNews[position].id.toString())
            }
        })

        holder.binding.klikDetail.setOnClickListener {
            val detail = Intent(it.context, DetailNewsActivity::class.java)
            detail.putExtra("detailnews", listNews[position].id)
            it.context.startActivity(detail)
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}