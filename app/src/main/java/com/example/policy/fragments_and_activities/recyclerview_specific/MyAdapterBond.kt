package com.example.policy.fragments_and_activities.recyclerview_specific

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.policy.R
import com.example.policy.models.Bond

class MyAdapterBond(c: Context, b:MutableList<Bond>, clickLstnr: ItemClickListener): RecyclerView.Adapter<MyAdapterBond.MyViewHolder>()
{
    var context: Context = c
    private var bonds: MutableList<Bond> = b
    var clickListener  = clickLstnr;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.my_row,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bigText.text = bonds[position].id.toString()
        holder.smallerText.text = bonds[position].policyid.toString()
        holder.cardPolicy.setOnClickListener {
            clickListener.onItemClick(bonds[position])
        }
    }

    override fun getItemCount(): Int {
        return bonds.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var bigText: TextView = itemView.findViewById(R.id.bigTxt)
        var smallerText: TextView = itemView.findViewById(R.id.valueTxt)
        var cardPolicy: CardView = itemView.findViewById(R.id.cardViewPolicy)
    }

    interface ItemClickListener {
        fun onItemClick(bond: Bond)
    }
}
