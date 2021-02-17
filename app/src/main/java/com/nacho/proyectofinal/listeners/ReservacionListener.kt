package com.nacho.proyectofinal.listeners

import com.nacho.proyectofinal.Reservacion

interface ReservacionListener {
    fun onClickReservacion(reservacion: Reservacion)

    //fun onShareParticipante(reservacion: Reservacion)
}