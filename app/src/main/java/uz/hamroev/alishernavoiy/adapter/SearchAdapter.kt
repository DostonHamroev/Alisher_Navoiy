package uz.hamroev.alishernavoiy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.alishernavoiy.databinding.ItemSearchBinding
import uz.hamroev.alishernavoiy.model.Mavzu


class SearchAdapter(var context: Context, var list: ArrayList<Mavzu>) :
    RecyclerView.Adapter<SearchAdapter.VhSearch>() {

    inner class VhSearch(var itemSearchBinding: ItemSearchBinding) :
        RecyclerView.ViewHolder(itemSearchBinding.root) {


        fun onBind(mavzu: Mavzu, position: Int) {
            itemSearchBinding.info.text = mavzu.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhSearch {
        return VhSearch(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VhSearch, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}