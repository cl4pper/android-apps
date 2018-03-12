package io.clapper.recyclerviewtemplate

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        recyclerView_main.setBackgroundColor( Color.GRAY )
        recyclerView_main.layoutManager = LinearLayoutManager( this )
        //recyclerView_main.layoutManager = GridLayoutManager( ? )
        //recyclerView_main.layoutManager = StaggeredGridLayoutManager( ? )

        recyclerView_main.adapter = MainAdapter()
    }
}