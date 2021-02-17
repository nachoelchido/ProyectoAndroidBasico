package com.nacho.proyectofinal

class Reservacion {
    var id : Int = 0
    var hotel : String = ""
    var dias : Int = 0
    var nombre_cliente : String = ""
    var habitaciones : Int = 0

    constructor(hotel: String, dias: Int, nombre_cliente: String, habitaciones: Int) {
        this.hotel = hotel
        this.dias = dias
        this.nombre_cliente = nombre_cliente
        this.habitaciones = habitaciones
    }

    constructor()
}