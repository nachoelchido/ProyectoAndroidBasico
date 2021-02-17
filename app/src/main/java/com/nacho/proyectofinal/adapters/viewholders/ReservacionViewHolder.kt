package com.nacho.proyectofinal.adapters.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nacho.proyectofinal.R
import com.nacho.proyectofinal.Reservacion
import com.nacho.proyectofinal.listeners.ReservacionListener
import kotlinx.android.synthetic.main.example_reservacion.view.*

class ReservacionViewHolder(val miView : View) : RecyclerView.ViewHolder(miView) {
    private var reservacionListener : ReservacionListener? = null
    private var reservacion : Reservacion? = null

    private var hotel : TextView = miView.findViewById(R.id.text_view_hotel)
    private var nombre : TextView = miView.findViewById(R.id.text_view_nombre)

    fun bindReservacion(reservacion: Reservacion){
        this.reservacion = reservacion
        hotel.text = this.reservacion?.hotel
        nombre.text = this.reservacion?.nombre_cliente

        itemView.setOnClickListener { view ->
            reservacionListener?.onClickReservacion(this.reservacion!!)
        }
    }
    fun setReservacionListener(listener: ReservacionListener?){
        this.reservacionListener = listener
    }
}
