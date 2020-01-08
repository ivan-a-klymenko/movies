package ru.bk.klim9.movies.ui.movies

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item.view.*
import ru.bk.klim9.movies.BuildConfig
import ru.bk.klim9.movies.movies.Movie

/**
 * @author Ivan
 */
private const val WIDTH_185 = "w185"
const val WIDTH_780 = "w780"
class MovieItemView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr){



    fun bind(movie: Movie) {
        val url = BuildConfig.IMAGES_BASE_URL + WIDTH_185 + movie.posterPath
        Picasso.with(movieItemImage.context)
            .load(url)
            .noFade()
            .into(movieItemImage)
        movieItemName.text = movie.title
    }

}