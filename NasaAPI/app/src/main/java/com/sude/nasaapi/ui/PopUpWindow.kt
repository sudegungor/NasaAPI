package com.sude.nasaapi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.sude.nasaapi.R

class PopUpWindow : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_window)




        val geri_button =  findViewById<Button>(R.id.geri_button)
        val item_photo = findViewById<ImageView>(R.id.popup_item_photo)
        val text_earth_date = findViewById<TextView>(R.id.popup_text_earth_date)
        val text_rover_name = findViewById<TextView>(R.id.popup_text_rover_name)
        val text_cam_full_name = findViewById<TextView>(R.id.popup_text_cam_full_name)
        val text_cam_name = findViewById<TextView>(R.id.popup_text_cam_name)
        val text_rover_status = findViewById<TextView>(R.id.popup_text_rover_status)
        val text_launch_date = findViewById<TextView>(R.id.popup_text_launch_date)
        val text_landing_date = findViewById<TextView>(R.id.popup_text_landing_date)



        val item_photo_text = intent.getStringExtra("item_photo")
        val earth_date = intent.getStringExtra("earth_date")
        val rover_name = intent.getStringExtra("rover_name")
        val cam_full_name = intent.getStringExtra("cam_full_name")
        val cam_name = intent.getStringExtra("cam_name")
        val rover_status = intent.getStringExtra("rover_status")
        val launch_date = intent.getStringExtra("launch_date")
        val landing_date = intent.getStringExtra("landing_date")




        Picasso.get()
                .load(item_photo_text)
                .resize(400,500)
                .into(item_photo)


        text_earth_date.text = "Fotoğrafın Çekildiği Tarih: " + earth_date
        text_rover_name.text = "Aracın Adı: " +rover_name
        text_cam_full_name.text = "Cameranın Full Adı: " +cam_full_name
        text_cam_name.text = "Cameranın Kısa Adı: " +cam_name
        text_rover_status.text = "Aracın Görev Durumu: " +rover_status
        text_launch_date.text = "Aracın Fırlatma Tarihi: " + launch_date
        text_landing_date.text = "Aracın İniş Tarihi: "+landing_date



        geri_button.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }






    }
}