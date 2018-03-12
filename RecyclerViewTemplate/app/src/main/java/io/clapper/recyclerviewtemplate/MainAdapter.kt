package io.clapper.recyclerviewtemplate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by cl4pper on 12/03/2018.
 */

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    // quantidade total de itens
    override fun getItemCount(): Int {
        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class CustomViewHolder( v: View ): RecyclerView.ViewHolder( v ) {
    //
}