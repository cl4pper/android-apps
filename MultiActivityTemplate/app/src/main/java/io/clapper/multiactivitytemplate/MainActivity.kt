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
        //output_text.setText( "Hello..." ) - proximo passo: reiniciar valor do texto exibido
    }

    fun sendName( view: View ) {

        var nameToSend = input_name.text.toString()
        nameToSend = "Hello, $nameToSend"
        changeText( nameToSend )

        // Create an Intent to start the second activity
        val returnIntent = Intent( this, ReturnActivity::class.java )

        // Add the value to the extras for the Intent
        returnIntent.putExtra( ReturnActivity.TEXT_A, nameToSend )

        // Start the new Activity - by the Intent
        startActivity( returnIntent )
    }

    fun changeText( txt: String ) {
        output_text.setText( txt )
    }
}
