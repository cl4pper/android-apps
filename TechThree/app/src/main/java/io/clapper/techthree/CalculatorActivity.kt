package io.clapper.techthree

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val submitButton: ImageView = findViewById( R.id.but_submit )

        // intent da activity principal
        val introActivity = Intent( this, MainActivity::class.java )

        // metodo do botao para retornar a activity inicial
        submitButton.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                submitButton.setImageResource( R.drawable.ic_button_pressed_80dp )
                startActivity( introActivity )
            }
        })
    }

    // para fazer o botao retornar ao estado original - antes do verde
    override fun onStop() {
        super.onStop()
        val submitButton: ImageView = findViewById( R.id.but_submit )
        submitButton.setImageResource( R.drawable.ic_button_80dp )
    }
}
