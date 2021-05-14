package com.mw21.codetest.presentation.colaborator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mw21.codetest.R
import com.mw21.codetest.data.models.employee.Employee
import kotlinx.android.synthetic.main.item_layout.view.*

class ColaboratorAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<MyViewHolder>(){
    val employeeList = ArrayList<Employee>()

    fun setList(heroe: List<Employee>){
        employeeList.clear()
        employeeList.addAll(heroe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var views = inflater.inflate(R.layout.item_layout, parent, false)

         val holder = MyViewHolder(views)
        views.setOnClickListener { listener.onItemClick(employeeList[holder.adapterPosition]) }

        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(employeeList[position])
    }

    override fun getItemCount(): Int =employeeList.size
}


class MyViewHolder(val item: View): RecyclerView.ViewHolder(item){
    fun bind(employee: Employee) {
        item.tvName.text = employee.name
        item.tvEmail.text = employee.mail
    }
}