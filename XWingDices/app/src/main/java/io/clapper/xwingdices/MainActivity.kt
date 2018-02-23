package io.clapper.xwingdices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Function to handle null input values.
    fun nullHandler( num: Int ) : Int {
        if( num != null ) {
            return num
        } else {
            return 0
        }
    } // nullHandler

    fun getDices() {
        var totalDices = R.id.input_dices

        println( totalDices )
    }

    fun pressButton( view: View) {
        getDices()
    }


}
