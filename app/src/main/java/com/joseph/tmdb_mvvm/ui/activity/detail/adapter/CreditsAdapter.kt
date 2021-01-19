package com.joseph.tmdb_mvvm.ui.activity.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joseph.tmdb_mvvm.R
import com.joseph.tmdb_mvvm.databinding.ItemCreditBinding
import com.joseph.tmdb_mvvm.model.MovieCredits

class CreditsAdapter: RecyclerView.Adapter<CreditsAdapter.CreditsViewHolder>() {

    private var creditList = mutableListOf<MovieCredits.Cast>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCreditBinding>(inflater, R.layout.item_credit,parent, false)

        return CreditsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreditsViewHolder, position: Int) {
        holder.onBind(creditList[position])
    }

    override fun getItemCount(): Int {
        return creditList.size
    }

    fun submitList(list: List<MovieCredits.Cast>) {
        creditList.addAll(list)
        notifyDataSetChanged()
    }

    class CreditsViewHolder(private var view: ItemCreditBinding): RecyclerView.ViewHolder(view.root){
        fun onBind(cast: MovieCredits.Cast) {
            view.credits = cast
        }
    }
}