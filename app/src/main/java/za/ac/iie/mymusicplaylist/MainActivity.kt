package za.ac.iie.mymusicplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.ArrayList

private fun Intent.putParcelableArrayListExtra(s: String, playlist: ArrayList<Song>) {
    TODO("Not yet implemented")
}

class MainActivity : AppCompatActivity() {

    // Data class for song information
    private var songTitle = mutableListOf<String>()
    private var artistName = mutableListOf<String>()
    private var Rating = mutableListOf<Int>()
    private var comments = mutableListOf<String>()


    private val playlist = arrayListOf<Song>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        val viewButton = findViewById<Button>(R.id.viewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            val title = findViewById<EditText>(R.id.inputSongTitle).text.toString()
            val artist = findViewById<EditText>(R.id.inputArtist).text.toString()
            val rating = findViewById<EditText>(R.id.inputRating).text.toString().toIntOrNull() ?: 1
            val comment = findViewById<EditText>(R.id.inputComment)

            if (playlist.size < 4) {
                playlist.add(Song(title, artist, rating, comment))
                Toast.makeText(this, "Song Added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Maximum 4 songs allowed", Toast.LENGTH_SHORT).show()
            }
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putParcelableArrayListExtra("playlist", playlist)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}








