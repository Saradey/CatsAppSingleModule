package com.evgeny.goncharov.catapp.feature.wall.cats.ui.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.evgeny.goncharov.catapp.feature.wall.cats.model.to.view.CatBreedModel
import kotlinx.android.synthetic.main.holder_cat_breed.view.*

class CatBreedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: CatBreedModel?) {
        item?.let {
            itemView.txvBreedName.text = item.name
            itemView.txvBreedDescription.text = item.description
            Glide.with(itemView)
                .load(item.urlImage)
                .apply(
                    RequestOptions()
                        .override(100, 100)
                        .centerCrop()
                )
                .into(itemView.imvShowCat)
            itemView.imbWiki.setOnClickListener {
                //TODO попытаться открыть неявным интентом
            }
        }
    }


}