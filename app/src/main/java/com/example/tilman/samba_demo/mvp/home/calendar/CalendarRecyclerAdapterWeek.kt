package com.example.tilman.samba_demo.mvp.home.calendar

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import kotlinx.android.synthetic.main.calendar_recycler_item.view.*

class CalendarRecyclerAdapterWeek(private val presenter: CalendarPresenter): RecyclerView.Adapter<CalendarViewHolderWeek>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolderWeek {

        return CalendarViewHolderWeek(LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item,parent, false))

    }

    override fun getItemCount(): Int {

        return presenter.showPartiesWeek().size

    }


    override fun onBindViewHolder(holder: CalendarViewHolderWeek, position: Int) {


        holder.tvTitle.text = presenter.showPartiesWeek()[position].name


    }



    override fun getItemId(position: Int): Long {

        return position.toLong()
    }


}



class CalendarViewHolderWeek(view: View): RecyclerView.ViewHolder(view) {


        val tvTitle = view.calendar_recycler_item_tv_title


}
