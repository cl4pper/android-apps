package io.clapper.techthree

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    //private val distance: EditText? = findViewById( R.id.input_distance )
    //private val quantity: EditText? = findViewById( R.id.input_vehicles )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val submitButton: ImageView = findViewById( R.id.but_submit )
        // radiobuttons: tipos de veiculo
        val light: RadioButton = findViewById( R.id.radio_light )
        val heavy: RadioButton = findViewById( R.id.radio_heavy )
        val motorbike: RadioButton = findViewById( R.id.radio_bike )

        // radiobuttons: tipos de combustivel
        val gasoline: RadioButton = findViewById( R.id.radio_gas )
        val etanol: RadioButton = findViewById( R.id.radio_eta )
        val diesel: RadioButton = findViewById( R.id.radio_die )

        // inputs
        val distance: EditText = findViewById( R.id.input_distance )
        val quantity: EditText = findViewById( R.id.input_vehicles )

        // intent da activity principal
        val introActivity = Intent( this, MainActivity::class.java )

        // metodo do botao para retornar a activity inicial
        submitButton.setOnClickListener( object : View.OnClickListener {
            override fun onClick(v: View?) {
                var dist = distance.text.toString()
                var quant = quantity.text.toString()
                if( ( dist == "") || ( quant == "" ) ) {
                    Toast.makeText( applicationContext, "All fields must be filled!", Toast.LENGTH_LONG ).show()
                } else {
                    submitButton.setImageResource( R.drawable.ic_button_pressed_80dp )
                    if( light.isChecked ) {
                        if( gasoline.isChecked ) {
                            var CO = calculateEmission( 0.33, dist, quant ) // monoxido de carbono
                            var CH4 = calculateEmission( 0.011, dist, quant ) // metano
                            var MP = calculateEmission( 0.0011, dist, quant ) // material particulado
                            //startActivity( introActivity )
                        } else if( etanol.isChecked ) {
                            var CO = calculateEmission( 0.56, dist, quant )
                            var CH4 = calculateEmission( 0.011, dist, quant )
                            var MP = calculateEmission( 0.0, dist, quant )
                            //startActivity( introActivity )
                        } else {
                            Toast.makeText( applicationContext, "Incorrect Car Type x Fuel!", Toast.LENGTH_LONG ).show()
                        }
                    } else if( heavy.isChecked ) {
                        if( diesel.isChecked ) {
                            var CO = calculateEmission( 1.06, dist, quant )
                            var MP = calculateEmission( 0.023, dist, quant )
                        } else {
                            Toast.makeText( applicationContext, "Incorrect Car Type x Fuel!", Toast.LENGTH_LONG ).show()
                        }
                    } else if( motorbike.isChecked ) {
                        if( gasoline.isChecked ) {
                            var CO = calculateEmission( 1.02, dist, quant )
                            var CH4 = calculateEmission( 0.03, dist, quant )
                            var MP = calculateEmission( 0.0035, dist, quant )
                        } else {
                            Toast.makeText( applicationContext, "Incorrect Car Type x Fuel!", Toast.LENGTH_LONG ).show()
                        }
                    }
                }
            }
        })
    }

    // para fazer o botao retornar ao estado original - antes do verde
    override fun onStop() {
        super.onStop()
        val submitButton: ImageView = findViewById( R.id.but_submit )
        submitButton.setImageResource( R.drawable.ic_button_80dp )
    }

    // METODOS FUNDAMENTAIS

    // calcular taxa de emissao
    fun calculateEmission( fator: Double, dist: String, quant: String ) : String {
        var Emission = quant.toDouble() * ( fator/1000 ) * dist.toDouble()
        return Emission.toString()
    }
}
