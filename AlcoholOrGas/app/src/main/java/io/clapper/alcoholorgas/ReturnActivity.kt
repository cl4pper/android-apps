package io.clapper.alcoholorgas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_return.*

class ReturnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        //
        showResult()
    }

    companion object {
        const val TEXT_RETURN = "..."
    }

    fun backToMain( view: View ) {
        //
        val mainIntent = Intent( this, MainActivity::class.java )
        startActivity( mainIntent )
    }

    fun showResult() {
        var txt = intent.getStringExtra( TEXT_RETURN )
        text_return.text = txt
    }
}
