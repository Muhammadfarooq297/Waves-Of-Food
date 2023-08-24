package com.example.wavesoffood.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class cartAdapter(private val cartItems:MutableList<String>,private val cartItemsPrice:MutableList<String>,private val cartImages:MutableList<Int>) :RecyclerView.Adapter<cartAdapter.cartViewHolder>() {

private val itemQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartViewHolder {
        val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return cartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: cartViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class cartViewHolder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity=itemQuantities[position]
                cartFoodName.text=cartItems[position]
                cartitemPrice.text=cartItemsPrice[position]
                cartImage.setImageResource(cartImages[position])
                cartQuantity.text=quantity.toString()

                binding.minusButton.setOnClickListener {
                    decreaseQuantity(position)

                }
                binding.plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                binding.deleteButton.setOnClickListener {
                    val itemPosition=adapterPosition
                    if(itemPosition!=RecyclerView.NO_POSITION)
                    {
                        deleteItem(itemPosition)
                    }

                }
            }

        }

        private fun increaseQuantity(position: Int)
        {
             if(itemQuantities[position]<10)
             {
                 itemQuantities[position]++
                 binding.cartQuantity.text=itemQuantities[position].toString()
             }
        }
        private fun decreaseQuantity(position: Int)
        {
            if(itemQuantities[position]>1)
            {
                itemQuantities[position]--
                binding.cartQuantity.text=itemQuantities[position].toString()
            }

        }
        private fun deleteItem(position: Int)
        {
           cartItems.removeAt(position)
           cartItemsPrice.removeAt(position)
           cartImages.removeAt(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position,cartItems.size)
        }

    }


}