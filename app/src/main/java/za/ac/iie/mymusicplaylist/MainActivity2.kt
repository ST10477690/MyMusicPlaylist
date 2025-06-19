package za.ac.iie.mymusicplaylist

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.ac.iie.mymusicplaylist.Song
import za.ac.iie.mymusicplaylist.withIndex
import java.lang.StringBuilder
import java.util.Locale
import kotlin.collections.arrayListOf
import za.ac.iie.mymusicplaylist.Song as MymusicplaylistSong
import za.ac.iie.mymusicplaylist.withIndex as withIndex1
import kotlin.collections.arrayListOf as arrayListOf1

private fun Any.map(x: Float): Any {
    TODO("Not yet implemented")
}

private fun Any.average(): Locale? {


    return TODO("Provide the return value")
}


private fun Intent.getParcelableArrayListExtra(): Any {

    return TODO("Provide the return value")
}

private operator fun Any.invoke(s: String): Any {
    TODO("Not yet implemented")
}

private fun Any.withIndex(): Any {


    class MainActivity2<Songs : Parcelable?> : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main2)

            val playlist = intent.getParcelableArrayListExtra()("playlist")
            val listOfSongs = findViewById<TextView>(R.id.listOfSongs)
            val displayButton = findViewById<Button>(R.id.AverageButton)
            val backButton = findViewById<Button>(R.id.backButton)

            //Display all songs
            val builder = StringBuilder()
            for ((index, song) in playlist.withIndex1()) {
                builder.append("Song ${index + 1}:/nTitle: ${song.title}/nArtist:${song.artist}/nRating: ${song.rating}/nComment: ${song.comment}/n/n")
            listOfSongs.text = builder.toString()

            //Average rating
            displayButton.setOnClickListener {
                val average = playlist.map(it.x).average()
                Toast.makeText(this, "Average Rating: %.2f".format(average), Toast.LENGTH_SHORT)
            }
            //Return
            backButton.setOnClickListener {
                finish()
            }







            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }




















