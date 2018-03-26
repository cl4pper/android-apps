package io.clapper.techthree

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReturnActivity : AppCompatActivity() {

    companion object {
        val CO_RESULT = "co"
        val CH4_RESULT = "ch4"
        val MP_RESULT = "mp"
    }

    //private val co: TextView = findViewById( R.id.return_co )
    //private val ch4: TextView = findViewById( R.id.return_ch4 )
    //private val mp: TextView = findViewById( R.id.return_mp )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)

        val co: TextView = findViewById( R.id.return_co )
        val ch4: TextView = findViewById( R.id.return_ch4 )
        val mp: TextView = findViewById( R.id.return_mp )

        var monoxido = intent.getStringExtra( CO_RESULT )
        var metano = intent.getStringExtra( CH4_RESULT )
        var particulas = intent.getStringExtra( MP_RESULT )

        co.text =  "$monoxido Kg"
        ch4.text = "$metano Kg"
        mp.text =  "$particulas Kg"
    }

    override fun onPause() {
        super.onPause()

        val co: TextView = findViewById( R.id.return_co )
        val ch4: TextView = findViewById( R.id.return_ch4 )
        val mp: TextView = findViewById( R.id.return_mp )

        co.text =  ""
        ch4.text = ""
        mp.text =  ""
    }
}
