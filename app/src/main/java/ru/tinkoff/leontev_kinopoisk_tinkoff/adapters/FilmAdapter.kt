package ru.tinkoff.leontev_kinopoisk_tinkoff.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.tinkoff.leontev_kinopoisk_tinkoff.databinding.ItemFilmBinding
import ru.tinkoff.leontev_kinopoisk_tinkoff.models.FilmModel

class FilmAdapter(
    private val itemFavoriteClick: (id: Long) -> Unit,
    private val itemClick: (id: Long) -> Unit
) : ListAdapter<FilmModel, FilmAdapter.ViewHolder>(FilmDiffUtilCallBack) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFilmBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val viewBinding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {


        fun bind(film: FilmModel) {
            with(viewBinding) {
                filmTitleTextView.text = film.title
                filmGenreTextView.text = film.genre
                Glide.with(itemView).load(film.filmImage).into(filmImageView)

                itemView.setOnLongClickListener {
                    itemFavoriteClick(film.id)
                    true
                }
                itemView.setOnClickListener {
                    itemClick(film.id)
                }
            }
        }
    }
}

object FilmDiffUtilCallBack : DiffUtil.ItemCallback<FilmModel>() {
    override fun areItemsTheSame(oldItem: FilmModel, newItem: FilmModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FilmModel, newItem: FilmModel): Boolean {
        return oldItem.id == newItem.id
    }
}