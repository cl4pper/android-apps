package io.clapper.buttoncounter

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // indica a classe que cada variavel pertence(dentro da view) - boas maneiras
    //private var textInput: EditText? = null
    //private var logTimes: TextView? = null
    //private var logNames: TextView? = null
    //
    //private var timesClicked = 0

    // chamado na primeira vez que a Activity e ativada - onde fica toda a parte estatica do codigo da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Varivaeis
        val logTimes: TextView = findViewById<TextView>( R.id.log_times )
        val logNames: TextView = findViewById<TextView>( R.id.log_names )
        val textInput: EditText = findViewById<EditText>( R.id.input_text )
        val butAdd: Button = findViewById<Button>( R.id.but_add )
        val butClr: Button = findViewById<Button>( R.id.but_clr )
        val resetTimes: Button = findViewById<Button>( R.id.reset_times )
        val resetNames: Button = findViewById<Button>( R.id.reset_names )
        var timesClicked = 0

        // atribuindo valores a variaveis
        logTimes?.text = "LOG:\n" // .text nao e uma String, e sim uma Editable
        logNames?.text = "NAMES:\n"
        textInput.setText( "" )

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


    // onde o app se torna visivel ao usuario
    override fun onStart() {
        super.onStart()
        val cycleName = Toast.makeText( this, "onStart", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    //
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val cycleName = Toast.makeText( this, "onRestoreInstanceState", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    // onde se inicia a interacao usuario x Activity
    override fun onResume() {
        super.onResume()
        val cycleName = Toast.makeText( this, "onResume", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    // chamado quando o sistema chama outra Activity - usado para salvar ateracoes (dados persistentes)
    // -> onResume() - se for mantida em segundo plano
    // -> onStop() - se for ocultada
    override fun onPause() {
        super.onPause()
        val cycleName = Toast.makeText( this, "onPause", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        val cycleName = Toast.makeText( this, "onSaveInstanceState", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    // chamada quando a Activity nao esta mais visivel ao usuario
    override fun onStop() {
        super.onStop()
        val cycleName = Toast.makeText( this, "onStop", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    // chamada na reinicializacao da Activity
    override fun onRestart() {
        super.onRestart()
        val cycleName = Toast.makeText( this, "onRestart", Toast.LENGTH_SHORT )
        cycleName.show()
    }

    // chamada antes da Activity ser destruida - ultima chamada da Activity
    override fun onDestroy() {
        super.onDestroy()
        val cycleName = Toast.makeText( this, "onDestroy", Toast.LENGTH_SHORT )
        cycleName.show()
    }
}
