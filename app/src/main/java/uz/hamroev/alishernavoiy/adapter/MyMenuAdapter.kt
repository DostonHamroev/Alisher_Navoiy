package uz.hamroev.alishernavoiy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.hamroev.alishernavoiy.databinding.ItemMenuBinding
import uz.hamroev.alishernavoiy.model.MyMenu

class MyMenuAdapter(
    var context: Context,
    var list: ArrayList<MyMenu>,
    var onMyMeneClickListener: onMyMeneClickListener
) :
    RecyclerView.Adapter<MyMenuAdapter.VhMenu>() {


    inner class VhMenu(var itemMenuBinding: ItemMenuBinding) :
        RecyclerView.ViewHolder(itemMenuBinding.root) {

        fun onBind(myMenu: MyMenu, position: Int) {
            itemMenuBinding.titleMenu.text = myMenu.title
            myMenu.img?.let { itemMenuBinding.imgMenu.setImageResource(it) }

            itemMenuBinding.root.setOnClickListener {
                onMyMeneClickListener.onMyClick(myMenu, position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhMenu {
        return VhMenu(ItemMenuBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VhMenu, position: Int) {
        return holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


interface onMyMeneClickListener {
    fun onMyClick(myMenu: MyMenu, position: Int)
}