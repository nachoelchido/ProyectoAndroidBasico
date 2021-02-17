package com.nacho.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agregar_reservacion.*

class AgregarReservacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_reservacion)

        val context = this

        agregarBtn.setOnClickListener {
            var reservacion = Reservacion(editTextHotel.text.toString(),
                    editTextDias.text.toString().toInt(),
                    editTextCliente.text.toString(),
                    editTextHabitaciones.text.toString().toInt())
            var db = DataBaseHandler(context)
            db.insertData(reservacion)
            editTextHotel.text = null
            editTextDias.text = null
            editTextCliente.text = null
            editTextHabitaciones.text = null
        }
    }
}