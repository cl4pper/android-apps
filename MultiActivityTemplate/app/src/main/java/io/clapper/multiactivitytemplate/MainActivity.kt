package io.clapper.multiactivitytemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendName( view: View ) {

        var nameToSend = input_name.text.toString()
        nameToSend = "Hello, $nameToSend"
        changeText( nameToSend )
        //
        val firstIntent = Intent( this, ReturnActivity::class.java )
        startActivity( firstIntent )
    }

    fun changeText( txt: String ) {
        output_text.setText( txt )
    }
}
