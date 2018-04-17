package io.clapper.munchkinmanager

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class PlayersActivity : AppCompatActivity() {

    companion object {
        val CELULAS = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        val playersList: ListView = findViewById( R.id.list_players )
        playersList.setBackgroundColor( Color.parseColor( "#FFFFFF" ))

        var valor = intent.getStringExtra( CELULAS ).toInt()

        playersList.adapter = PlayerCardsAdapter( this, valor )
    }

    private class PlayerCardsAdapter( context: Context, numero: Int ): BaseAdapter() {

        private val myContext: Context
        private val celulas: Int

        init {
            myContext = context
            celulas = numero
        }

        override fun getCount(): Int {
            return celulas
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST"
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from( myContext )
            val rowMain = layoutInflater.inflate( R.layout.activity_rows, parent, false )
            return rowMain
            //val textView = TextView(myContext)
            //textView.text = "HERE IS A ROW"
            //return textView
        }
    }
}
