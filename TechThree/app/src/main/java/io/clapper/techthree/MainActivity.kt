package io.clapper.techthree

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: ImageView = findViewById( R.id.but_next )

        // intent para a activity da calculadora
        val calculatorActivity = Intent( this, CalculatorActivity::class.java )

        // metodo do botao avancar para proxima activity
        nextButton.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                nextButton.setImageResource( R.drawable.ic_pressed_80dp )
                startActivity( calculatorActivity )
            }
        })
    }

    // para fazer o botao retornar ao estado original - antes do verde
    override fun onStop() {
        super.onStop()
        //Toast.makeText( applicationContext, "onStop", Toast.LENGTH_LONG ).show()
        val nextButton: ImageView = findViewById( R.id.but_next )
        nextButton.setImageResource( R.drawable.ic_next_24dp )
    }
}
