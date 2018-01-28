package io.clapper.randomnumberapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun randomizeNumber(view: View) {
        var textA = findViewById<View>(R.id.numberView) as TextView
        var randomNumber = Random().nextInt(6) + 1

        textA.setText("$randomNumber") // Formatacao para exibir valores numericos como string.
    }
}
