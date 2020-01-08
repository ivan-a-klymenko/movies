package ru.bk.klim9.movies.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bk.klim9.movies.R
import ru.bk.klim9.movies.movies.Movie

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
class MoviesAdapter(private val callback: Callback) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    interface Callback {
        fun itemClick(movie: Movie)
    }

    private val items = ArrayList<Movie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return MovieViewHolder(view as MovieItemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = items[position]
        holder.movieItemView.bind(movie)
        holder.movieItemView.setOnClickListener { callback.itemClick(movie) }
    }

    override fun getItemCount() = items.size

    fun setData(newItems: List<Movie>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }


    class MovieViewHolder(val movieItemView: MovieItemView) : RecyclerView.ViewHolder(movieItemView)
}