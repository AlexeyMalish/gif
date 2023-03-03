package com.example.vkgif.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkgif.R
import com.example.vkgif.databinding.GiphyItemBinding
import com.example.vkgif.data.GifDTO

class GifListAdapter(val mGifList:List<GifDTO>): RecyclerView.Adapter<GifListAdapter.GifListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifListHolder {
        return GifListHolder(GiphyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GifListHolder, position: Int) {
        val gifItem = mGifList[position]
        holder.bindData(gifItem)

        holder.itemView.setOnClickListener{
            val url  = gifItem.images.original.url
            val title = gifItem.title
            val source = gifItem.source
            val date = gifItem.date
            val bundle = bundleOf("url" to url, "title" to title, "source" to source, "date" to date )
            Navigation.findNavController(it).navigate(R.id.action_destination_main_fragment_to_destination_fragment_gif_page, bundle)
        }
    }

    override fun getItemCount(): Int {
        return mGifList.size
    }

    class GifListHolder(val binding:GiphyItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(gif : GifDTO){
            Glide.with(binding.giphyIv.context)
                .load(gif.images.original.url)
                .into(binding.giphyIv)


        }
    }
}