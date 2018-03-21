package io.clapper.buttoncounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // indica a classe que cada variavel pertence(dentro da view) - boas maneiras
    private var textInput: EditText? = null
    private var textLog: TextView? = null
    //
    private var timesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        textInput= findViewById<EditText>(R.id.input_text)
        textLog = findViewById<TextView>(R.id.text_log)
        val but_pressHere: Button = findViewById<Button>(R.id.but_pressHere)
        val but_reset: Button = findViewById<Button>(R.id.but_reset)
        //
        textLog?.text = "Log:\n"

        // adiciona o movimento de scroll view ao widget (neste caso, ao text_log)
        textLog?.movementMethod = ScrollingMovementMethod()
        // funcao para rodar a cada click no botao
        but_pressHere.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                timesClicked += 1
                textLog?.append( "Clicked $timesClicked time" )
                // adicionar o s dependendo da quantidade de vezes clicadas
                if( timesClicked > 1 ) {
                    textLog?.append( "s.\n" )
                } else {
                    textLog?.append( ".\n" )
                }
            }
        })

        // funcao para resetar o log e o timesClicked(= 0)
        but_reset.setOnClickListener( object : View.OnClickListener {
            override fun onClick( v: View? ) {
                timesClicked = 0
                textLog?.text = "Log:\n"
            }
        })
    }
}
