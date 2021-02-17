package com.nacho.proyectofinal

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DB_NAME = "AppDB"
val TABLE_NAME = "Reservaciones"
val COL_ID = "id"
val COL_HOTEL = "hotel"
val COL_DIAS = "dias"
val COL_NOMBRE_CLIENTE = "nombre_cliente"
val COL_HABITACIONES = "habitaciones"

class DataBaseHandler(var context : Context) : SQLiteOpenHelper(context, DB_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_HOTEL + " VARCHAR(56)," +
                COL_DIAS + " INTEGER," +
                COL_NOMBRE_CLIENTE + " VARCHAR(128)," +
                COL_HABITACIONES + " INTEGER)";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(reservacion: Reservacion){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_HOTEL,reservacion.hotel)
        cv.put(COL_DIAS,reservacion.dias)
        cv.put(COL_NOMBRE_CLIENTE,reservacion.nombre_cliente)
        cv.put(COL_HABITACIONES,reservacion.habitaciones)
        var result = db.insert(TABLE_NAME,null, cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Ocurrió un error",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Reservación agregada",Toast.LENGTH_SHORT).show()
    }

    fun readData() : MutableList<Reservacion>{
        var list : MutableList<Reservacion> = ArrayList()
        val db = this.readableDatabase
        val query =  "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                val reservacion = Reservacion()
                reservacion.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                reservacion.hotel = result.getString(result.getColumnIndex(COL_HOTEL))
                reservacion.dias = result.getString(result.getColumnIndex(COL_DIAS)).toInt()
                reservacion.nombre_cliente = result.getString(result.getColumnIndex(COL_NOMBRE_CLIENTE))
                reservacion.habitaciones = result.getString(result.getColumnIndex(COL_HABITACIONES)).toInt()
                list.add(reservacion)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

}