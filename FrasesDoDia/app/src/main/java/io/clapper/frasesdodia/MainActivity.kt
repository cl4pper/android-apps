package io.clapper.frasesdodia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // lateinit - indica que essa variavel sera utilizada mais a frente (mas e inicializada agora)
    lateinit var mensagem: TextView
    val frase = arrayOf(
            "Could you tell me your name?",
            "Could you describe yourself to me?",
            "Where are you from?",
            "What is your favorite band?",
            "What is your favorite movie?",
            "What is your favorite color?",
            "What is your favorite sport?",
            "What is your favorite beer?",
            "What is your favorite video game?"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Acessando o layout da activity_main (atraves do metodo R)
        setContentView(R.layout.activity_main)

        // as TypeVar - "casting" (converte a variavel para o tipo TypeVar)
        mensagem = findViewById<TextView>(R.id.textMain) as TextView
    }

    // Funcoes chamadas atraves do "onClick", DEVEM ter parametro do tipo View.
    fun gerarFrase(view: View) {

        val totalItensArray = frase.size
        val randomNum = Random().nextInt( totalItensArray )

        mensagem.setText( frase[ randomNum ])
    }
}
