package ru.tinkoff.leontev_kinopoisk_tinkoff.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.tinkoff.leontev_kinopoisk_tinkoff.R
import ru.tinkoff.leontev_kinopoisk_tinkoff.adapters.FilmAdapter
import ru.tinkoff.leontev_kinopoisk_tinkoff.base.BaseFragment
import ru.tinkoff.leontev_kinopoisk_tinkoff.databinding.FragmentFilmListBinding
import ru.tinkoff.leontev_kinopoisk_tinkoff.filmDetails.FilmFragment

private const val EMPTY_STRING = ""

class FilmListFragment : BaseFragment() {

    lateinit var viewModel: FilmListViewModel

    private var _viewBinding: FragmentFilmListBinding? = null
    val viewBinding get() = _viewBinding!!

    private val adapter = FilmAdapter(::onFavoriteClick, ::onItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[FilmListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFilmListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            recyclerFilmList.adapter = adapter

            searchImageView.setOnClickListener {
                onSearchVisible()
            }
            backImageView.setOnClickListener {
                onSearchGone()
            }

            searchView.queryHint = "Поиск"
            searchView.isIconified = false
            searchView.onActionViewExpanded()
        }

        initObserve()
        viewModel.loadFilms()
    }

    private fun initObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.films.collect { data ->
                adapter.submitList(data)
            }
        }
    }

    private fun onSearchVisible() {
        viewBinding.toolbar.title = EMPTY_STRING
        viewBinding.searchImageView.isVisible = false
        viewBinding.backImageView.isVisible = true
        viewBinding.searchView.isVisible = true
    }

    private fun onSearchGone() {
        viewBinding.toolbar.title = resources.getString(R.string.popular_text)
        viewBinding.searchImageView.isVisible = true
        viewBinding.backImageView.isVisible = false
        viewBinding.searchView.isVisible = false
    }

    private fun onItemClick(id: Long) {
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack("FilmListTag")
            replace<FilmFragment>(R.id.navHostMain)
        }
    }

    private fun onFavoriteClick(id: Long) {

    }
}