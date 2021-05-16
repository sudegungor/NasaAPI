package com.sude.nasaapi.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.sude.nasaapi.R
import com.sude.nasaapi.adapter.CuriosityAdapter
import com.sude.nasaapi.adapter.OpportunityAdapter
import com.sude.nasaapi.adapter.SpiritAdapter
import com.sude.nasaapi.model.curiosity.Curiosity
import com.sude.nasaapi.model.opportunity.Opportunity
import com.sude.nasaapi.model.spirit.spirit


class HepsiniGoruntuleFragment : Fragment() {

    private val op_dataList: MutableList<com.sude.nasaapi.model.opportunity.Photo> = mutableListOf()
    private val cru_dataList: MutableList<com.sude.nasaapi.model.curiosity.Photo> = mutableListOf()
    private val spirit_dataList: MutableList<com.sude.nasaapi.model.spirit.Photo> = mutableListOf()
    private lateinit var opportunityAdapter: OpportunityAdapter
    private lateinit var curiosityAdapter: CuriosityAdapter
    private lateinit var spirityAdapter: SpiritAdapter




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        val view :View  = inflater.inflate(R.layout.fragment_hepsini_goruntule, container, false)

        val recycler_view = view.findViewById(R.id.recycler_view) as RecyclerView



        opportunityAdapter = OpportunityAdapter(op_dataList)
        curiosityAdapter = CuriosityAdapter(cru_dataList)
        spirityAdapter = SpiritAdapter(spirit_dataList)



        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.addItemDecoration(DividerItemDecoration(this.context, OrientationHelper.VERTICAL))



        val concatAdapter = ConcatAdapter(opportunityAdapter, curiosityAdapter, spirityAdapter)


        recycler_view.setAdapter(concatAdapter)


        AndroidNetworking.initialize(this.context)
        AndroidNetworking.get("https://api.nasa.gov/mars-photos/api/v1/rovers/opportunity/photos?sol=1000&api_key=kzqTPSa70ZQXNEfI8SAu17o1104R0dCqFW4PC0UQ")
            .build()
            .getAsObject(Opportunity::class.java, object : ParsedRequestListener<Opportunity> {

                override fun onResponse(response: Opportunity?) {
                    if (response != null) {
                        op_dataList.addAll(response.photos)
                        opportunityAdapter.notifyDataSetChanged()
                    }
                }

                override fun onError(anError: ANError?) {
                    TODO("Not yet implemented")
                }


            })


        AndroidNetworking.initialize(this.context)
        AndroidNetworking.get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=kzqTPSa70ZQXNEfI8SAu17o1104R0dCqFW4PC0UQ")
            .build()
            .getAsObject(Curiosity::class.java, object : ParsedRequestListener<Curiosity> {

                override fun onResponse(response: Curiosity?) {
                    if (response != null) {
                        cru_dataList.addAll(response.photos)
                        curiosityAdapter.notifyDataSetChanged()
                    }
                }

                override fun onError(anError: ANError?) {
                    TODO("Not yet implemented")
                }




            })




        AndroidNetworking.initialize(this.context)
        AndroidNetworking.get("https://api.nasa.gov/mars-photos/api/v1/rovers/spirit/photos?sol=1000&api_key=kzqTPSa70ZQXNEfI8SAu17o1104R0dCqFW4PC0UQ")
            .build()
            .getAsObject(spirit::class.java, object : ParsedRequestListener<spirit> {

                override fun onResponse(response: spirit?) {
                    if (response != null) {
                        spirit_dataList.addAll(response.photos)
                        spirityAdapter.notifyDataSetChanged()
                    }
                }

                override fun onError(anError: ANError?) {
                    TODO("Not yet implemented")
                }




            })


        return view
    }




}