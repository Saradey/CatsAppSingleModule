package com.evgeny.goncharov.catapp.common.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.evgeny.goncharov.catapp.MainActivity
import com.evgeny.goncharov.catapp.R
import com.evgeny.goncharov.catapp.consts.KEY_BUNDLE_CAT_ID
import com.evgeny.goncharov.catapp.feature.splash.screen.ui.SplashScreenFragment
import com.evgeny.goncharov.catapp.feature.wall.cats.ui.CatDescriptionFragment
import com.evgeny.goncharov.catapp.feature.wall.cats.ui.WallCatsFragment
import javax.inject.Inject

class NavigationImpl @Inject constructor() : INavigation {

    private var activity: MainActivity? = null


    override fun attachActivity(mainActivity: MainActivity) {
        activity = mainActivity
    }


    override fun detachActivity() {
        activity = null
    }


    override fun goTo(destination: Destination) {
        activity?.let {
            when (destination) {
                Destination.SplashScreen -> goToSplashScreenScreen()
                Destination.CatWallScreen -> goToCatWallScreen()
            }
        }
    }


    override fun goTo(destination: Destination, bundle: Bundle) {
        activity?.let {
            when (destination) {
                Destination.CatDescription -> goToTheCatDescription(bundle)
            }
        }
    }


    private fun goToTheCatDescription(bundle: Bundle) {
        val id = bundle.getString(KEY_BUNDLE_CAT_ID)
        val fragment = CatDescriptionFragment.getInstance(id)
        activity?.supportFragmentManager?.beginTransaction()
            ?.hide(
                activity?.supportFragmentManager?.fragments?.find {
                    it is WallCatsFragment
                }!!
            )
            ?.add(R.id.frmRootField, fragment, CatDescriptionFragment::class.java.name)
            ?.addToBackStack(CatDescriptionFragment::class.java.name)
            ?.commit()
    }


    private fun goToSplashScreenScreen() {
        val fragment = SplashScreenFragment.getInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frmRootField, fragment)
            ?.commit()
    }


    private fun goToCatWallScreen() {
        val fragment = WallCatsFragment.getInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frmRootField, fragment, WallCatsFragment::class.java.name)
            ?.commit()
    }


    override fun getNowMatchFromStack(): Int {
        return activity?.supportFragmentManager?.fragments?.size ?: 0
    }


    override fun appFinish() {
        activity?.finish()
    }


    override fun popStack() {
        activity?.supportFragmentManager?.popBackStack()
    }
}