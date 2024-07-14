package com.fmd.yemekkitabi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fmd.yemekkitabi.databinding.RecyclerRowBinding
import com.fmd.yemekkitabi.ListeFragment
import com.fmd.yemekkitabi.ListeFragmentDirections
import com.fmd.yemekkitabi.model.tarif

class Tarifadapter(val tarifListesi:List<tarif>):RecyclerView.Adapter<Tarifadapter.TarifHolder>() {

    class TarifHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarifHolder {
        val recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TarifHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return tarifListesi.size
    }

    override fun onBindViewHolder(holder: TarifHolder, position: Int) {
        holder.binding.recyclerViewTextView.text=tarifListesi[position].isim
        holder.itemView.setOnClickListener{
            val action=ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi="eski",id=tarifListesi[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}