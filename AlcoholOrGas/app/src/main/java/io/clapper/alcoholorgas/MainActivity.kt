package io.clapper.alcoholorgas

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.fixedRateTimer

private const val TAG_ALC = "ValueAlc"
private const val TAG_GAS = "ValueGas"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butCalculate: Button = findViewById( R.id.but_calculate )
        val inputAlc: TextView = findViewById( R.id.input_alc )
        val inputGas: TextView = findViewById( R.id.input_gas )
        val textReturn: TextView = findViewById( R.id.text_return )
        val clearAlc: Button = findViewById( R.id.clr_alc )
        val clearGas: Button = findViewById( R.id.clr_gas )

        val resultView = Intent( this, ReturnActivity::class.java )
        
        butCalculate.setOnClickListener( object : View.OnClickListener {
            override fun onClick( v: View? ) {
                var alcool = inputAlc.text.toString()
                var gasolina = inputGas.text.toString()
                //

                if( ( alcool == "" ) || ( gasolina == "" ) ) {
                    textReturn.text = "Tente novamente."
                    Toast.makeText( applicationContext, "Insira todos os valores!", Toast.LENGTH_LONG ).show()
                } else {
                    var resultado = calculate( alcool, gasolina )
                    resultView.putExtra( ReturnActivity.TEXT_RETURN, resultado )
                    startActivity( resultView )
                }
                //
            }
        })

        clearAlc.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                inputAlc.text = ""
            }
        })

        clearGas.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                inputGas.text = ""
            }
        })
    } // onCreate

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //outState?.putString( TAG_ALC, "" )
        outState?.putString( TAG_ALC, input_alc?.text.toString() )
        outState?.putString( TAG_GAS, input_gas?.text.toString() )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        //input_alc?.text = savedInstanceState?.getString( TAG_ALC, "" )
        //input_gas?.text = savedInstanceState?.getString( TAG_GAS, "" )
    }

    override fun onStop() {
        super.onStop()
        val textReturn: TextView = findViewById( R.id.text_return )

        textReturn.text = "Preencha ambos os campos."
    }

    fun calculate( alc: String, gas: String ) : String {
        var cal = alc.toDouble() / gas.toDouble()
        if( cal < 0.7 ) {
            return "Comprar Alcool."
        } else {
            return "Comprar Gasolina."
        }
    }
}