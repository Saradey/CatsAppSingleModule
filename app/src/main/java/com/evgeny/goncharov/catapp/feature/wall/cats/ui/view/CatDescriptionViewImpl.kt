package com.evgeny.goncharov.catapp.feature.wall.cats.ui.view

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import com.evgeny.goncharov.catapp.R
import com.evgeny.goncharov.catapp.base.BaseViewImpl
import com.evgeny.goncharov.catapp.feature.wall.cats.model.to.view.CatDescriptionModel
import com.evgeny.goncharov.catapp.feature.wall.cats.ui.CatDescriptionFragment
import kotlinx.android.synthetic.main.fragment_cat_description.view.*
import javax.inject.Inject

class CatDescriptionViewImpl : BaseViewImpl(), ICatDescriptionView {


    override fun init() {
        CatDescriptionFragment.component.inject(this)
    }


    override fun setCatDescription(model: CatDescriptionModel?) {
        model?.let {
            content?.apply {
                txvNameCat.text = resources.getString(R.string.name_cat_title, model.name)
                txvOrigin.text = resources.getString(R.string.origin_cat_title, model.origin)
                txvWeight.text = resources.getString(R.string.weight_cat_title, model.weight)
                txvLifeSpan.text = resources.getString(R.string.life_span_cat_title, model.lifeSpan)
                txvTemperament.text =
                    resources.getString(R.string.temperament_cat_title, model.temperament)
                txvDescription.text =
                    resources.getString(R.string.description_cat_title, model.description)
                llButtonWiki.setOnClickListener {
                    val uri = Uri.parse(model.urlWiki)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    }
                }
            }
        }
    }


}