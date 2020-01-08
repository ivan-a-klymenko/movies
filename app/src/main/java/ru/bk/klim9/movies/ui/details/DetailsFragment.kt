package ru.bk.klim9.movies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.details_fragment.*
import ru.bk.klim9.movies.BuildConfig
import ru.bk.klim9.movies.R
import ru.bk.klim9.movies.movies.Movie
import ru.bk.klim9.movies.ui.movies.WIDTH_780
import javax.inject.Inject

private const val MOVIE_ID = "movie_id"

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance(movieId: Int) = DetailsFragment().apply {
            arguments = bundleOf(MOVIE_ID to movieId)
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DetailsViewModel
    private var movieId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(MOVIE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailsViewModel::class.java)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel.movieLd.observe(this, Observer {
            it?.let {
                updateUi(it)
            }
        })
        viewModel.observeMovie(movieId)

    }

    private fun updateUi(it: Movie) {
        title.text = it.title
        overview.text = it.overview
        var average = it.voteAverage.toString()
        average = if (average.length > 3) average.substring(0, 3) else average
        average = if (average.length == 3 && average[2] == '0') average.substring(0, 1) else average
        rating.text = average
        val url = BuildConfig.IMAGES_BASE_URL + WIDTH_780 + it.posterPath
        Picasso.with(detailImage.context)
            .load(url)
            .noFade()
            .into(detailImage)
    }

    private fun initUi() {

    }

}
