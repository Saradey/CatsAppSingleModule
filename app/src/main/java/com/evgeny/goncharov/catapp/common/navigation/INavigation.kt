package com.evgeny.goncharov.catapp.common.navigation

import com.evgeny.goncharov.catapp.MainActivity

interface INavigation {

    fun attachActivity(mainActivity: MainActivity)

    fun detachActivity()

    fun goTo(destination: Destination)

    fun getNowMatchFromStack(): Int

    fun appFinish()

    fun popStack()


}