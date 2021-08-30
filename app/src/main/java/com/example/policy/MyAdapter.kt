package com.example.policy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.policy.models.Policy


class MyAdapter(c:Context, p:MutableList<Policy>, clickLstnr:ItemClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    var context:Context = c
    private var policies: MutableList<Policy> = p
    var clickListener  = clickLstnr;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.my_row,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.companyNameText.text = policies[position].company_adminemail
        holder.sumInsuredText.text = policies[position].suminsured.toString()
        holder.cardPolicy.setOnClickListener {
            clickListener.onItemClick(policies[position])
        }
    }

    override fun getItemCount(): Int {
        return policies.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var companyNameText: TextView = itemView.findViewById(R.id.companyNameTxt)
        var sumInsuredText: TextView = itemView.findViewById(R.id.sumInsuredTxt)
        var cardPolicy: CardView = itemView.findViewById(R.id.cardViewPolicy)
    }

    interface ItemClickListener {
        fun onItemClick(policy: Policy)
    }
}
