package com.nacho.proyectofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_reservacion.view.*

class ReservacionAdapter(private val reservacionList : List<Reservacion>) : RecyclerView.Adapter<ReservacionAdapter.ReservacionViewHolder>() {

    private var reservacionListener : ReservacionListener? = null
    private var reservacion:Reservacion? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservacionViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_reservacion,
        parent,false)
        itemView.setOnClickListener{
                view ->
            reservacionListener?.onClickReservacion(this.reservacion!!)
        }
        return ReservacionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReservacionViewHolder, position: Int) {
        this.reservacion = reservacionList[position]
        val currentItem = reservacionList[position]
        holder.textViewHotel.text = currentItem.hotel
        holder.textViewNombre.text = currentItem.nombre_cliente
    }

    override fun getItemCount() = reservacionList.size

    class ReservacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewHotel : TextView = itemView.text_view_hotel
        val textViewNombre : TextView = itemView.text_view_nombre
    }
}