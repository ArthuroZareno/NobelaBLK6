package com.example.nobelablk6.Ui.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nobelablk6.R
import com.example.nobelablk6.Ui.models.NobelaResponseItem

class NobelaAdapter: RecyclerView.Adapter<NobelaAdapter.NobelaViewHolder>() {

    inner class NobelaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    lateinit var nobelaImage: Image
    lateinit var nobelaSource: TextView
    lateinit var nobelaTitle: TextView
    lateinit var nobelaDescription: TextView
    lateinit var nobelaDateTime: TextView

    private val differCallback = object : DiffUtil.ItemCallback<NobelaResponseItem>(){
        override fun areItemsTheSame(
            oldItem: NobelaResponseItem,
            newItem: NobelaResponseItem
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: NobelaResponseItem,
            newItem: NobelaResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NobelaViewHolder {
        return NobelaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_nobela, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((NobelaResponseItem) -> Unit)? = null

    override fun onBindViewHolder(holder: NobelaViewHolder, position: Int) {
        val nobelaResponseItem = differ.currentList[position]

        nobelaImage = holder.itemView.findViewById(R.id.nobelaImage)
        nobelaSource = holder.itemView.findViewById(R.id.nobelaSource)
        nobelaTitle = holder.itemView.findViewById(R.id.nobelaTitle)
        nobelaDescription = holder.itemView.findViewById(R.id.nobelaDescription)
        nobelaDateTime = holder.itemView.findViewById(R.id.nobelaDateTime)

        holder.itemView.apply {
            Glide.with(this).load(nobelaResponseItem.image).into(nobelaImage)
            nobelaTitle.text = nobelaResponseItem.source?.name
            nobelaSource.text = nobelaResponseItem.title
            nobelaDescription.text = nobelaResponseItem.description


            setOnClickListener{
                onItemClickListener?.let {
                    it(nobelaResponseItem)
                }
            }
        }
    }
    fun setOnItemClickListener(lisener: (NobelaResponseItem) -> Unit){
        onItemClickListener = lisener
    }
}