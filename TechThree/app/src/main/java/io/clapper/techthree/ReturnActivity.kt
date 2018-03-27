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

        //val co: TextView = findViewById( R.id.return_co )
        //val ch4: TextView = findViewById( R.id.return_ch4 )
        //val mp: TextView = findViewById( R.id.return_mp )
        val result: TextView = findViewById( R.id.text_result )

        var monoxido = intent.getStringExtra( CO_RESULT )
        var metano = intent.getStringExtra( CH4_RESULT )
        var particulas = intent.getStringExtra( MP_RESULT )

        //co.text =  "CO: $monoxido Kg"
        //ch4.text = "CH4: $metano Kg"
        //mp.text =  "MP: $particulas Kg"

        result.text = "CO: $monoxido Kg"
        result.append( "\nCH4: $metano Kg" )
        result.append( "\nMP: $particulas Kg" )
    }

    override fun onStop() {
        super.onStop()

        //val co: TextView = findViewById( R.id.return_co )
        //val ch4: TextView = findViewById( R.id.return_ch4 )
        //val mp: TextView = findViewById( R.id.return_mp )
        val result: TextView = findViewById( R.id.text_result )

        //co.text =  ""
        //ch4.text = ""
        //mp.text =  ""

        result.text = ""
    }
}
