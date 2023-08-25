package com.example.wavesoffood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.PopularitemBinding

class PopularAdapter(private val items:List<String>,private val prices:List<String>, private val images:List<Int>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item=items[position]
        val price=prices[position]
        val image=images[position]
        holder.bind(item,price,image)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder(private val binding:PopularitemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView=binding.popularimageView
        fun bind(item: String,price: String, image: Int) {
            binding.foodNamePopular.text=item
            binding.pricePopular.text=price
            imageView.setImageResource(image)


        }

    }

}