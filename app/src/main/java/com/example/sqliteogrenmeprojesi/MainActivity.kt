package com.example.sqliteogrenmeprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // try catch

        try {
                    //******* veritabanı oluşturma
            val veritabani = this.openOrCreateDatabase("Urunler", MODE_PRIVATE, null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler(id INTEGER PRIMARY KEY,isim VARCHAR,fiyat INT)")

                        //******veri ekleme
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Ayakkabi',100)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Elbise',200)")
            //veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Tshirt',30)")

                    //********silme işlemi
            //veritabani.execSQL("DELETE FROM urunler WHERE id=2")

                    //********güncelleme işlemi
            veritabani.execSQL("UPDATE urunler SET fiyat=210 WHERE isim='Elbise'")

                //**********listeleme işlemi
            // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%t'", null)

            // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id=3", null)

            // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim='Tshirt'", null)

            val cursor = veritabani.rawQuery("SELECT * FROM urunler", null)

            //********console yazdırma
            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()) {
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("Isim : ${cursor.getString(isimColumnIndex)}")
                println("Fiyat: ${cursor.getInt(fiyatColumnIndex)}")
            }

            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}