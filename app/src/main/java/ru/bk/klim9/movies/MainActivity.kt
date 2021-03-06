package ru.bk.klim9.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.bk.klim9.movies.ui.movies.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesFragment.newInstance())
                .commitNow()
        }
    }

}
