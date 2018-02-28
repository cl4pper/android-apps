package io.clapper.multiactivitytemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_return.*

class ReturnActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        //
        shows()
    }

    companion object {
        const val TEXT_A = "param"
    }

    fun shows() {
        // Get the value from intent extras
        val txt = intent.getStringExtra( TEXT_A )

        // Pass the value from intent to the text on the screen
        text_hello.text = txt
    }
}
