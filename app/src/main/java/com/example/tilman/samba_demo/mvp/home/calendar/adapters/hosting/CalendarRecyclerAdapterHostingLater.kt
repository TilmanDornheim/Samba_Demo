package com.example.tilman.samba_demo.mvp.home.calendar.adapters.hosting

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tilman.samba_demo.R
import com.example.tilman.samba_demo.mvp.home.calendar.CalendarContract.CalendarPresenter
import kotlinx.android.synthetic.main.calendar_recycler_item.view.*

class CalendarRecyclerAdapterHostingLater(private val presenter: CalendarPresenter): RecyclerView.Adapter<CalendarViewHolderHostingLater>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolderHostingLater {

        return CalendarViewHolderHostingLater(LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item, parent, false))

    }

    override fun getItemCount(): Int {

        return presenter.showHostingLater().size

    }

    override fun onBindViewHolder(holder: CalendarViewHolderHostingLater, position: Int) {

        holder.tvTitle.text = presenter.showHostingLater()[position].name

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }


}



class CalendarViewHolderHostingLater(view: View): RecyclerView.ViewHolder(view) {

    val tvTitle = view.calendar_recycler_item_tv_title



}
