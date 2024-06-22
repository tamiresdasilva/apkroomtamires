package com.example.apkroomtamires.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.apkroomtamires.R
import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.databinding.ProdutoItemBinding


class ProductAdapter(
//    private val list: MutableList<Product>,
    val goToDetails: (produto: Produto) -> Unit,
    val removeItem: (produto: Produto) -> Unit,
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var list: List<Produto> = emptyList()
    private lateinit var binding: ProdutoItemBinding
    private lateinit var context: Context


    fun setUpList(list: List<Produto>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(private val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(produto: Produto) {
            binding.produto = produto

            binding.root.setOnClickListener {
                goToDetails(produto)
            }

            binding.root.setOnLongClickListener {
                showPopUpMenu(it, position, context)
                true
            }
        }
    }

    private fun showPopUpMenu(view: View, position: Int, context: Context) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.remove -> {
                        removeItem(list[position])
                        true
                    }

                    else -> {
                        Log.i("erro", "erro")
                        false
                    }
                }
            }
            inflate(R.menu.menu_popup)
            show()
        }
    }
}

