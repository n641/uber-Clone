package com.example.loginscreen.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginscreen.Data.Rides
import com.example.loginscreen.R

class RidesAdapter( val RidesList : List<com.example.loginscreen.Api.Rides>): RecyclerView.Adapter<RidesAdapter.RidesViewAdapter>() {


        class RidesViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var from: TextView
            var to: TextView
            lateinit var dateTo: TextView
            lateinit var dateFrom: TextView
            lateinit var price: TextView
            lateinit var time: TextView

            init{
                from = itemView.findViewById(R.id.from)
                to = itemView.findViewById(R.id.to)
                dateTo = itemView.findViewById(R.id.Dateto)
                dateFrom = itemView.findViewById(R.id.DateFrom)
                price = itemView.findViewById(R.id.price)
                time = itemView.findViewById(R.id.time)


            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RidesViewAdapter {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.list_rides, parent, false)
            return RidesViewAdapter(view)
        }

        override fun onBindViewHolder(holder: RidesViewAdapter, position: Int) {
            holder.from.setText(RidesList[position].from)
            holder.to.setText(RidesList[position].to)
            holder.dateTo.setText(RidesList[position].dateTo)
            holder.dateFrom.setText(RidesList[position].dateFrom)
            holder.price.setText(RidesList[position].price)
            holder.time.setText(RidesList[position].time)

        }

        override fun getItemCount(): Int {
            return RidesList.size
        }
    }
