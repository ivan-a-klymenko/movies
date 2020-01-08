package ru.bk.klim9.movies.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.movies_fragment.*
import ru.bk.klim9.movies.R
import ru.bk.klim9.movies.movies.Movie
import ru.bk.klim9.movies.ui.common.IApiErrorMessage
import ru.bk.klim9.movies.ui.details.DetailsFragment
import javax.inject.Inject

class MoviesFragment : Fragment(), MoviesAdapter.Callback, IApiErrorMessage {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUi()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesViewModel::class.java)
        setViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies()
    }

    private fun setViewModel() {
        viewModel.loadingLd.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.apiErrorLd.observe(this, Observer {
            showApiError(it)
        })
        viewModel.moviesLd.observe(this, Observer {
            emptyMessage.visibility = if (it.isNullOrEmpty()) View.VISIBLE else View.GONE
            it?.let {
                adapter.setData(it)
            }
        })
    }

    private fun initUi() {
        adapter = MoviesAdapter(this)
        moviesList.adapter = adapter
        moviesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        moviesList.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun itemClick(movie: Movie) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailsFragment.newInstance(movie.id))
            .addToBackStack(DetailsFragment::class.java.simpleName)
            .commit()

    }

    override fun localContext(): FragmentActivity = requireActivity()

}
