package io.clapper.alcoholorgas

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonResult( view: View ) {
        //
        val returnIntent = Intent( this, ReturnActivity::class.java )
        // getter do preco do alcool da view
        // val priceAlcohol = findViewById<View>(R.id.edit_alcohol_price) as EditText OU (usando o plugin)
        var priceAlcohol = edit_alcohol_price
        var textoRecuperadoAlc = priceAlcohol.text.toString()
        //
        var priceGas = edit_gas_price
        var textoRecuperadoGas = priceGas.text.toString()
        //
        var resultado: String? = null

        //Log.i( "RESULTADO", "texto recuperado do Alcool: $textoRecuperadoAlc" )

        var validacao = validateInput( textoRecuperadoGas, textoRecuperadoAlc )
        if ( validacao ) {
            resultado = calcular(textoRecuperadoGas, textoRecuperadoAlc)
            returnIntent.putExtra( ReturnActivity.TEXT_RETURN, resultado )
            Log.i( "Hello", "$resultado" )
            startActivity( returnIntent )
        } else {
            //text_result.setText("Insira os valores.")
            text_title.text = "Insira os valores!"
            calculate.setBackgroundColor( Color.parseColor( "#FF0000" ) )
            val myToast = Toast.makeText(this, "Valores incorretos!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        /*
        returnIntent.putExtra( ReturnActivity.TEXT_RETURN, resultado )
        startActivity( returnIntent )
        */
    }

    fun calcular(priceGas: String, priceAlc: String) : String {
        var valorGas = priceGas.toDouble()
        var valorAlc = priceAlc.toDouble()

        if (valorAlc / valorGas >= 0.7) {
            //text_result.setText("Comprar Álcool.")
            return "Comprar Álcool"
        } else {
            //text_result.setText("Comprar Gasolina.")
            return "Comprar Gasolina"
        }
    }

    fun validateInput ( priceGas: String, priceAlc: String ) : Boolean {
        var validateResult = true

        if ((priceAlc == null) || (priceGas == null) || (priceAlc == "") || (priceGas == "")) {
        //if (( priceAlc.toInt() >= 0.0 ) || ( priceGas.toInt() >= 0.0 ) || ( priceAlc == "" ) || ( priceGas == "" ) || ( priceAlc == null ) || ( priceGas == null ) ) {
            validateResult = false
        }

        return validateResult
    }
}