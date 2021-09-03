package com.example.policy.fragments_and_activities.recyclerview_specific

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.policy.R
import com.example.policy.models.Claim

class MyAdapterClaim(c: Context, cl:MutableList<Claim>, clickLstnr: ItemClickListener): RecyclerView.Adapter<MyAdapterClaim.MyViewHolder>()
{
    var context: Context = c
    private var claims: MutableList<Claim> = cl
    var clickListener  = clickLstnr;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.my_row,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.reasonText.text = claims[position].reason
        holder.claimAmtText.text = claims[position].claim_amount.toString()
        holder.cardPolicy.setOnClickListener {
            clickListener.onItemClick(claims[position])
        }
    }

    override fun getItemCount(): Int {
        return claims.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var reasonText: TextView = itemView.findViewById(R.id.bigTxt)
        var claimAmtText: TextView = itemView.findViewById(R.id.valueTxt)
        var cardPolicy: CardView = itemView.findViewById(R.id.cardViewPolicy)
    }

    interface ItemClickListener {
        fun onItemClick(claim: Claim)
    }
}
