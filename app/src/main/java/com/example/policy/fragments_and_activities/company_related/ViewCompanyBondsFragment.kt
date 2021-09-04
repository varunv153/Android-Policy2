package com.example.policy.fragments_and_activities.company_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.policy.R
import com.example.policy.databinding.FragmentViewCompanyBondsBinding
import com.example.policy.fragments_and_activities.recyclerview_specific.MyAdapterBond
import com.example.policy.models.Bond
import com.example.policy.viewmodels.MyAdapterViewModel
import com.example.policy.viewmodels.ViewCompanyBondsViewModel

class ViewCompanyBondsFragment : Fragment(), MyAdapterBond.ItemClickListener
{
    private var binding: FragmentViewCompanyBondsBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    private val viewModel2: ViewCompanyBondsViewModel by viewModels()
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentViewCompanyBondsBinding.inflate(inflater,container,false)
        viewModel2.viewCompanyBonds()
        viewModel2.result.observe(viewLifecycleOwner,{
            lateinit var bonds:MutableList<Bond>
            try {
                if (it.isSuccessful) {
                    Log.e("success",it.body().toString())
                    bonds = it.body()!!
                }
                else {
                    val errorbody = it.errorBody()!!.string()
                    Log.e("errorbody", errorbody)
                }
            }
            catch(e:Exception)
            {
                Log.e("Exception",e.toString())
            }
            val recyclerView = binding?.recyclerViewCompanyBonds
            recyclerView?.adapter = MyAdapterBond(container!!.context, bonds,this)
            recyclerView?.layoutManager = LinearLayoutManager(context)
        })
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewCompanyBondsFragment = this
    }
    override fun onItemClick(bond: Bond){
        viewModel.bond = bond
        viewModel.bond?.let { Log.e("bond id", it.id.toString()) }
        findNavController().navigate(R.id.action_viewCompanyBondsFragment_to_detailsBondFragment)
    }
}