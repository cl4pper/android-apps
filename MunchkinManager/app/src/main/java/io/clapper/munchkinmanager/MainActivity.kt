package io.clapper.munchkinmanager

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val PlayersView = Intent( this, PlayersActivity::class.java )

        val adicionar: ImageView = findViewById( R.id.but_add )
        val remover: ImageView = findViewById( R.id.but_rem )
        val play: ImageView = findViewById( R.id.but_play )
        val quantJogadores: TextView = findViewById( R.id.text_quant )

        adicionar.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                //
                var numero = quantJogadores.text.toString().toInt()
                numero = numero + 1
                var retorno = testarZero( numero )
                quantJogadores.text = retorno.toString()
            }
        })

        remover.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                //
                var numero = quantJogadores.text.toString().toInt()
                numero = numero - 1
                var retorno = testarZero( numero )
                quantJogadores.text = retorno.toString()
            }
        })

        play.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity( PlayersView )
            }
        })
    }

    fun testarZero( value: Int ): Int {
        if( value > 0 ) {
            return value
        } else {
            return 0
        }
    }
}
