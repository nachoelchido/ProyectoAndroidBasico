package com.nacho.proyectofinal.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nacho.proyectofinal.R
import com.nacho.proyectofinal.Reservacion
import com.nacho.proyectofinal.adapters.viewholders.ReservacionViewHolder
import com.nacho.proyectofinal.listeners.ReservacionListener

class ReservacionAdapter(val reservaciones: List<Reservacion>) : RecyclerView.Adapter<ReservacionViewHolder>() {
    private var reservacionListener : ReservacionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservacionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.example_reservacion, parent, false)
        val reservacionViewHolder = ReservacionViewHolder(itemView)
        reservacionViewHolder.setReservacionListener(reservacionListener)

        return reservacionViewHolder
    }

    override fun getItemCount(): Int {
        return reservaciones.size
    }

    override fun onBindViewHolder(holder: ReservacionViewHolder, position: Int) {
       holder.bindReservacion(reservaciones[position])
    }

    fun setReservacionListener(listener: ReservacionListener?){
        this.reservacionListener = listener
    }
}