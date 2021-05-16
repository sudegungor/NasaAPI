package com.sude.nasaapi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sude.nasaapi.holder.OpHolder
import com.sude.nasaapi.ui.PopUpWindow
import com.sude.nasaapi.R
import com.sude.nasaapi.model.opportunity.Photo
import kotlinx.android.synthetic.main.curiosity_item_view.view.*
import kotlinx.android.synthetic.main.opportunity_item_view.view.*

class OpportunityAdapter (private val dataList: MutableList<Photo>) : RecyclerView.Adapter<OpHolder>() {

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpHolder {
        context = parent.context
        return OpHolder(LayoutInflater.from(context).inflate(R.layout.opportunity_item_view, parent, false))
    }

    override fun getItemCount(): Int {

        return dataList.size
    }



    override fun onBindViewHolder(holder: OpHolder, position: Int) {

        val data = dataList[position]

        val item_photo = holder.itemView.item_photo
        val text_rover_name = holder.itemView.rover_name



        val earth_date = "${data.earthDate}"
        val rover_name = "${data.rover.name}"
        val cam_full_name = "${data.camera.fullName}"
        val cam_name = "${data.camera.name}"
        val rover_status = "${data.rover.status}"
        val launch_date = "${data.rover.launchDate}"
        val landing_date = "${data.rover.landingDate}"

        text_rover_name.text = rover_name




        Picasso.get()
                .load(data.imgSrc.replace("http:", "https:"))
                .resize(400,500)
                .into(item_photo)


        item_photo.setOnClickListener {


            val intent = Intent(context, PopUpWindow::class.java)

            intent.putExtra("item_photo", data.imgSrc.replace("http:", "https:"))
            intent.putExtra("earth_date", earth_date)
            intent.putExtra("rover_name", rover_name)
            intent.putExtra("cam_full_name", cam_full_name)
            intent.putExtra("cam_name", cam_name)
            intent.putExtra("rover_status", rover_status)
            intent.putExtra("launch_date", launch_date)
            intent.putExtra("landing_date", landing_date)

            context.startActivity(intent)


        }



    }

}