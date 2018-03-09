package io.clapper.gotboardgameapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
    }
    // for minus button on layout
    fun decrem( view: View ) {
        //
        var rounds = text_round.text.toString()
        var finalResult = decrementAction( rounds )
        text_round.text = finalResult
    }
    // for plus button on layout
    fun increm( view: View ) {
        //
        var rounds = text_round.text.toString()
        var finalResult = incrementAction( rounds )
        text_round.text = finalResult
    }
    //
    fun decrementAction( value: String ) : String {
        var newValue = value.toInt()
        if( value.toInt() == 1 ) {
            return newValue.toString()
        } else {
            newValue --
            return newValue.toString()
        }
    }
    //
    fun incrementAction( value: String ) : String {
        var newValue = value.toInt()
        newValue ++
        return newValue .toString()
    }
    //
    fun getValue( view: View ) : String {
        var roundNumber = text_round.text.toString()
        return roundNumber
    }
}
