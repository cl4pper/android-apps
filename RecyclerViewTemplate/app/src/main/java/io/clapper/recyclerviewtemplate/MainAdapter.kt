package io.clapper.recyclerviewtemplate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_row.view.*

/**
 * Created by cl4pper on 12/03/2018.
 */

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    //
    val houses_name = listOf<String>( "Lannister", "Stark", "Greyjoy", "Baratheon", "Martell", "Tyrell" )

    // quantidade total de itens
    override fun getItemCount(): Int {
        return houses_name.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //
        val layoutInflater = LayoutInflater.from( parent?.context )
        val componente = layoutInflater.inflate( R.layout.recycler_row, parent, false )
        //
        return CustomViewHolder( componente )
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        //
        var house_position = houses_name.get( position )
        holder?.itemView?.house_name?.text = house_position
    }
}

class CustomViewHolder( v: View ): RecyclerView.ViewHolder( v ) {
    //
}