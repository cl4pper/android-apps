package io.clapper.buttoncounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // indica a classe que cada variavel pertence(dentro da view) - boas maneiras
    //private var textInput: EditText? = null
    private var logTimes: TextView? = null
    private var logNames: TextView? = null
    //
    private var timesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Varivaeis
        logTimes = findViewById<TextView>( R.id.log_times )
        logNames = findViewById<TextView>( R.id.log_names )
        val textInput: EditText = findViewById<EditText>( R.id.input_text )
        val butAdd: Button = findViewById<Button>( R.id.but_add )
        val butClr: Button = findViewById<Button>( R.id.but_clr )
        val resetTimes: Button = findViewById<Button>( R.id.reset_times )
        val resetNames: Button = findViewById<Button>( R.id.reset_names )

        // atribuindo valores a variaveis
        logTimes?.text = "LOG:\n" // .text nao e uma String, e sim uma Editable
        logNames?.text = "NAMES:\n"

        // adiciona o movimento de scroll view ao widget (neste caso, ao text_log)
        logTimes?.movementMethod = ScrollingMovementMethod()
        logNames?.movementMethod = ScrollingMovementMethod()

        // funcao para rodar a cada click no botao
        butAdd.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                // imprimir a quantidade de vezes do botao pressionado
                timesClicked += 1
                logTimes?.append( "Clicked $timesClicked time" )
                // adicionar o "s" dependendo da quantidade de vezes clicadas
                if( timesClicked > 1 ) {
                    logTimes?.append( "s.\n" )
                } else {
                    logTimes?.append( ".\n" )
                }
                // transformar tetInput.text em uma variavel String e imprimir
                var printingName: String? = textInput?.text.toString()
                logNames?.append( "$printingName\n" )
            }
        })

        // botao para limpar caixa de texto
        butClr.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                textInput?.text.clear()
            }
        })

        // funcao para resetar o log das vezes clicadas
        resetTimes.setOnClickListener( object : View.OnClickListener {
            override fun onClick( v: View? ) {
                timesClicked = 0
                logTimes?.text = "LOG:\n"
            }
        })

        // funcao para resetar o log dos nomes inseridos
        resetNames.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                logNames?.text = "NAMES:\n"
            }
        })
    }
}
