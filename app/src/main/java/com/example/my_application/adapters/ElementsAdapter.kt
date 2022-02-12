package com.example.my_application.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.my_application.R
import com.example.my_application.classes.Element

class ElementsAdapter(private val listener: ItemClickListener, private val elements: MutableList<Element>): RecyclerView.Adapter<ElementsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_element, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avatar.setImageResource(elements[position].getAvatar())
        holder.elementTitle.text = elements[position].getTitle()
        holder.elementDescription.text = elements[position].getDescription()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            holder.avatar.transitionName = elements[position].getTitle()
        holder.elementLayout.setOnClickListener {
            listener.onItemClick(elements[position], holder.avatar)
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val elementLayout: ConstraintLayout = itemView.findViewById(R.id.ConstraintLayout)
        val avatar: AppCompatImageView = itemView.findViewById(R.id.avatar)
        val elementTitle: TextView = itemView.findViewById(R.id.elementTitle)
        val elementDescription: TextView = itemView.findViewById(R.id.elementDescription)
    }

    interface ItemClickListener {
        fun onItemClick(element: Element, view: AppCompatImageView)
    }
}