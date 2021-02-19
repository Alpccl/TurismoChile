package com.example.turismochile.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.turismochile.databinding.RegionItemListBinding
import com.example.turismochile.model.local.entities.RegionEntity

class RegionAdapter : RecyclerView.Adapter<RegionAdapter.RegionVH>() {
    private var listRegion = listOf<RegionEntity>()
    private val selectedRegion = MutableLiveData<RegionEntity>()

    fun update(list: List<RegionEntity>){
        listRegion = list
        notifyDataSetChanged()
    }

    fun selectedRegion(): LiveData<RegionEntity> = selectedRegion

    inner class RegionVH(private val binding: RegionItemListBinding):
            RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        fun bind(regionid: RegionEntity){
            binding.tvRegion.text = regionid.id.toString()
           Glide.with(binding.imVRegion).load(regionid.scrImage).into(binding.imVRegion)
        }
        override fun onClick(v: View?) {
            selectedRegion.value = listRegion[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionVH {
        return RegionVH(RegionItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RegionVH, position: Int) {
        holder.bind(listRegion[position])
    }

    override fun getItemCount() = listRegion.size
}