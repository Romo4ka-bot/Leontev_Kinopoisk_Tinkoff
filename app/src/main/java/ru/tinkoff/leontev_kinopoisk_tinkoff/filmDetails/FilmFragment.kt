package ru.tinkoff.leontev_kinopoisk_tinkoff.filmDetails

import android.os.Bundle
import android.view.*
import moxy.MvpAppCompatFragment
import ru.tinkoff.leontev_kinopoisk_tinkoff.databinding.FragmentFilmDetailsBinding


class FilmFragment : MvpAppCompatFragment() {

    private var _viewBinding: FragmentFilmDetailsBinding? = null
    val viewBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFilmDetailsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}