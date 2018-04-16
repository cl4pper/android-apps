package io.clapper.munchkinmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adicionar: Button = findViewById( R.id.but_add )
        val remover: Button = findViewById( R.id.but_remove )
        val quantJogadores: TextView = findViewById( R.id.text_quant )

        adicionar.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                //
                var numero = quantJogadores.toString().toInt()
                numero++
                quantJogadores.text = numero.toString()
            }
        })

        remover.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                //
                var numero = quantJogadores.toString().toInt()
                numero--
                quantJogadores.text = numero.toString()
            }
        })
    }
}
