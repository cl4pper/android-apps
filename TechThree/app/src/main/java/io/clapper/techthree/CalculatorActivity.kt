package io.clapper.techthree

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val backButton: ImageView = findViewById( R.id.but_back )

        // intent da activity principal
        val introActivity = Intent( this, MainActivity::class.java )

        // metodo do botao para retornar a activity inicial
        backButton.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                backButton.setImageResource( R.drawable.ic_back_pressed_80dp )
                startActivity( introActivity )
            }
        })
    }

    // para fazer o botao retornar ao estado original - antes do verde
    override fun onStop() {
        super.onStop()
        val backButton: ImageView = findViewById( R.id.but_back )
        backButton.setImageResource( R.drawable.ic_back_80dp )
    }
}
