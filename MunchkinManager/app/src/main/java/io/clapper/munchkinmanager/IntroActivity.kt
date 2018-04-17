package io.clapper.munchkinmanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val start: Button = findViewById( R.id.but_start )

        val MainView = Intent( this, MainActivity::class.java )

        start.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                // vai para a tela de numero de jogadores
                startActivity( MainView )
            }
        })
    }
}
