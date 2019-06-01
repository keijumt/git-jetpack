package keijumt.gitjetpack

import android.app.Application
import android.content.Context
import keijumt.gitjetpack.core.di.CoreModule
import keijumt.gitjetpack.core.di.DaggerCoreComponent

class App : Application() {

    companion object {
        fun coreComponent(context: Context) =
            (context.applicationContext as App).coreComponent
    }

    private val coreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }
}