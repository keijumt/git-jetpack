package keijumt.gitjetpack

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import keijumt.gitjetpack.di.createAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return createAppComponent()
    }
}