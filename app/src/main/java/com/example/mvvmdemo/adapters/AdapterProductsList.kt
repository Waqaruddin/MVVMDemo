package com.example.mvvmdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.data.model.Product
import kotlinx.android.synthetic.main.row_adapter_products.view.*

class AdapterProductsList(var mContext: Context, var mList:List<Product>):RecyclerView.Adapter<AdapterProductsList.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_products, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var product = mList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:List<Product>){
        mList = l
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(product:Product){
            itemView.text_view_product_names.text = product.productName

        }
    }
}