package com.celalalbayrak.sqlitekotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val database_name = "Veritabanim"
val table_name = "kullanicilar"
val col_name ="adisoyadi"
val col_age = "yasi"
val col_id = "id"

class  DatabaseHelper (var context: Context): SQLiteOpenHelper(context,
    database_name,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        // veritabın oluştuğunda birkez çalışır
        var createTable = " CREATE TABLE "+ table_name +"(" +
                col_id +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                col_name +" VARCHAR(250),"+
                col_age +" INTEGER)"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // veritabanı yükseltmek için kullanılır
    }
//Veri kaydetmek için fonksiyon tanımlıyoruz.
fun insertData(kullanici: kullanici){
    val db = this.writableDatabase
    val cv = ContentValues()
    cv.put(col_name,kullanici.adsoyad)
    cv.put(col_age,kullanici.yasi)
    var sonuc = db.insert(table_name,null,cv)
    if (sonuc == (-1).toLong()){
        Toast.makeText(context,"hatali", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context,"Başarılı", Toast.LENGTH_SHORT).show()
    }
}

}