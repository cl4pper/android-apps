package io.clapper.buttoncounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // indica a classe que cada variavel pertence(dentro da view) - boas maneiras
    private var text_input: EditText? = null
    private var text_log: TextView? = null
    private var but_pressHere: Button? = null
    private var but_reset: Button? = null
    //
    private var timesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        text_input = findViewById<EditText>(R.id.input_text)
        text_log = findViewById<TextView>(R.id.text_log)
        but_pressHere = findViewById<Button>(R.id.but_pressHere)
        but_reset = findViewById<Button>(R.id.but_reset)

        // funcao para rodar a cada click no botao
        but_pressHere?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                timesClicked += 1
                text_log?.append("\nThe button has been clicked $timesClicked times.")
            }
        })

        // funcao para resetar o log e o timesClicked(= 0)
        but_reset?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                timesClicked = 0
                text_log?.text = "Log starts down here:"
            }
        })
    }
}
