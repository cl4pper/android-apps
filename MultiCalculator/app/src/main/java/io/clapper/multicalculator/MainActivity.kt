package io.clapper.multicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // lateinit - e um valor nao Null, que sera definido posteriormente (so usado em var)
    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    // lazy - inicializa com um valor que pode ser alterado (so usado em val )
    private val displayOperation by lazy( LazyThreadSafetyMode.NONE ) { findViewById<TextView>( R.id.text_signal ) }

    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById( R.id.text_top )
        newNumber = findViewById( R.id.text_bot )

        val button0: Button = findViewById( R.id.but_0 )
        val button1: Button = findViewById( R.id.but_1 )
        val button2: Button = findViewById( R.id.but_2 )
        val button3: Button = findViewById( R.id.but_3 )
        val button4: Button = findViewById( R.id.but_4 )
        val button5: Button = findViewById( R.id.but_5 )
        val button6: Button = findViewById( R.id.but_6 )
        val button7: Button = findViewById( R.id.but_7 )
        val button8: Button = findViewById( R.id.but_8 )
        val button9: Button = findViewById( R.id.but_9 )

        val dot: Button = findViewById( R.id.but_dot )
        val equals: Button = findViewById( R.id.but_equals )

        val buttonPlus: Button = findViewById( R.id.but_plus )
        val buttonMinus: Button = findViewById( R.id.but_minus )
        val buttonMulti: Button = findViewById( R.id.but_multi )
        val buttonDiv: Button = findViewById( R.id.but_div )

        // funcao para adicionar algarismos ao numero que sera utilizado
        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append( b.text )
        }

        button0.setOnClickListener( listener )
        button1.setOnClickListener( listener )
        button2.setOnClickListener( listener )
        button3.setOnClickListener( listener )
        button4.setOnClickListener( listener )
        button5.setOnClickListener( listener )
        button6.setOnClickListener( listener )
        button7.setOnClickListener( listener )
        button8.setOnClickListener( listener )
        button9.setOnClickListener( listener )
    }
}
