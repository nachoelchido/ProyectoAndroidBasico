package com.nacho.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nacho.proyectofinal.adapters.ReservacionAdapter
import com.nacho.proyectofinal.listeners.ReservacionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ReservacionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        var db = DataBaseHandler(context)
        val data = db.readData()

        agregar_resrvacion_btn.setOnClickListener {
            val detailIntent = Intent (this, AgregarReservacionActivity::class.java)
            startActivity(detailIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        val context = this
        var db = DataBaseHandler(context)
        val data = db.readData()

        val reservacionAdapter = ReservacionAdapter(data)
        reservacionAdapter.setReservacionListener(this)
        recycler_view.adapter = reservacionAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onClickReservacion(reservacion: Reservacion) {
        Toast.makeText(this, "Le dio click a ${reservacion.hotel}",Toast.LENGTH_LONG).show()
    }
}