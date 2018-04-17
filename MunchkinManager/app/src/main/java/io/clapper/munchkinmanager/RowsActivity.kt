package io.clapper.munchkinmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class RowsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rows)

        // itens da descricao dos jogadores
        val raca: TextView = findViewById( R.id.text_type )
        val classe: TextView = findViewById( R.id.text_class )

        // itens da forca
        val texto_forca: TextView = findViewById( R.id.text_str )
        val rem_forca: TextView = findViewById( R.id.but_rem_str )
        val num_forca: TextView = findViewById( R.id.num_str )

        // itens do nivel
        val texto_nivel: TextView = findViewById( R.id.text_lev )
        val num_nivel: TextView = findViewById( R.id.num_lev )
        val rem_niv: TextView = findViewById( R.id.but_rem_lev )

        // alteracao do valor da FORCA
        num_forca.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                var numero = num_forca.text.toString().toInt()
                numero = numero + 1
                num_forca.text = numero.toString()
            }
        })

        // alteracao do valor do NIVEL
        num_nivel.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                var numero = num_nivel.text.toString().toInt()
                numero = numero + 1
                var teste = checarNivelMaximo( numero )
                num_nivel.text = teste.toString()

            }
        })

        // reduzir valor da FORCA
        rem_forca.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                var numero = num_forca.text.toString().toInt()
                numero = numero - 1
                var teste = checarZero( numero )
                num_forca.text = teste.toString()
            }
        })

        // reduzir valor do NIVEL
        rem_niv.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                var numero = num_nivel.text.toString().toInt()
                numero = numero - 1
                var teste = checarZero( numero )
                num_nivel.text = teste.toString()
            }
        })
    } // fim onCreate()

    fun checarZero( value: Int ): Int {
        if( value >= 0 ) {
            return value
        } else {
            return 0
        }
    }

    fun checarNivelMaximo( value: Int ): Int {
        if( value >= 10 ) {
            return 10
        } else {
            return value
        }
    }
}
