package io.clapper.multicalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instancia dos botoes
        val zero: Button = findViewById( R.id.but_0 )
        val one: Button = findViewById( R.id.but_1 )

        /*
        zero.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                zero.setBackgroundColor( Color.parseColor( "#ffffff" ) )
            }
        })

        one.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                one.setBackgroundColor( Color.parseColor( "#ffffff" ) )
            }
        })
        */
    }
}
