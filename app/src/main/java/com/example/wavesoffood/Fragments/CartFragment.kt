package com.example.wavesoffood.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.Adapter.cartAdapter
import com.example.wavesoffood.PayOutActivity
import com.example.wavesoffood.R
import com.example.wavesoffood.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var  binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentCartBinding.inflate(inflater,container,false)
        val cartFoodNames= listOf("Burger","Sandwich","Momo","Item","Sandwich","Momo")
        val cartItemPrice= listOf("$5","$6","$7","$8","$9","$10")
        val cartImage= listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu5,R.drawable.menu6)
        val adapter=cartAdapter(ArrayList(cartFoodNames),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartrecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.cartrecyclerView.adapter=adapter

        binding.proceedButton.setOnClickListener {
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

    }
}