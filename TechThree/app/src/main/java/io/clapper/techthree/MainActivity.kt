package io.clapper.techthree

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: ImageView = findViewById( R.id.but_start )

        // intent para a activity da calculadora
        val calculatorActivity = Intent( this, CalculatorActivity::class.java )

        // metodo do botao avancar para proxima activity
        startButton.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                startButton.setImageResource( R.drawable.ic_button_pressed_80dp )
                startActivity( calculatorActivity )
            }
        })
    }

    // para trocar background (sorteio) - e cor do titulo (adaptar)
    override fun onStart() {
        super.onStart()
        //Toast.makeText( applicationContext, "onStart", Toast.LENGTH_LONG ).show()
        var randBack = Random().nextInt( 3 ) + 1
        // troca de image background
        when( randBack ) {
            1 -> img_back.setImageResource( R.drawable.back2 )
            2 -> img_back.setImageResource( R.drawable.back3 )
            3 -> img_back.setImageResource( R.drawable.back4 )
            else -> img_back.setImageResource( R.drawable.back2 )
        }
        // adapta a cor do titulo
        when( randBack ) {
            1 -> text_title.setTextColor( Color.parseColor( "#000000" ) )
            2 -> text_title.setTextColor( Color.parseColor( "#000000" ) )
            3 -> text_title.setTextColor( Color.parseColor( "#ffffff" ) )
            else -> text_title.setTextColor( Color.parseColor( "#000000" ) )
        }
    }

    // para fazer o botao retornar ao estado original - antes do verde
    override fun onStop() {
        super.onStop()
        //Toast.makeText( applicationContext, "onStop", Toast.LENGTH_LONG ).show()
        val startButton: ImageView = findViewById( R.id.but_start )
        startButton.setImageResource( R.drawable.ic_button_80dp )
    }
}
