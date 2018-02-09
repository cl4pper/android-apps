package io.clapper.alcoholorgas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonResult( view: View ) {
        // getter do preco do alcool na(da) view
        // val priceAlcohol = findViewById<View>(R.id.edit_alcohol_price) as EditText OU (usando o plugin)
        val priceAlcohol = edit_alcohol_price
        val textoRecuperadoAlc = priceAlcohol.text.toString()
        // OU val textoRecuperado = priceAlcohol.text

        val priceGas = edit_gas_price
        val textoRecuperadoGas = priceGas.text

        Log.i( "RESULTADO", "texto recuperado do Alcool: $textoRecuperadoAlc" )
        Log.i( "RESULTADO", "texto recuperado da Gasolina: $textoRecuperadoGas" )
    }
}
