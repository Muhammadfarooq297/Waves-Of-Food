package com.example.wavesoffood.Adapter

import android.app.SearchManager.OnCancelListener
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.databinding.MenuItemBinding

class menuAdapter(private val menuItems:MutableList<String>,private val menuItemPrice:MutableList<String>,private val menuImages:MutableList<Int>,private val requireContext: Context):RecyclerView.Adapter<menuAdapter.MenuViewHolder>() {
    private val itemClickListener: OnClickListener ?= null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
       val binding=MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int =menuItems.size

    inner class MenuViewHolder(private val binding:MenuItemBinding):RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position= adapterPosition
                if(position!=RecyclerView.NO_POSITION)
                {
                    itemClickListener?.onItemClick(position)
                }
                //Set on Click listener to open details
                val intent=Intent(requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItems.get(position))
                intent.putExtra("MenuItemImage",menuImages.get(position))
                requireContext.startActivity(intent)


            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text=menuItems[position].toString()
                menuPrice.text=menuItemPrice[position].toString()
                menuImage.setImageResource(menuImages[position])


            }

        }


    }
    interface OnClickListener {

        fun onItemClick(position: Int)
        {

        }

    }


}

