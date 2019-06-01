package keijumt.gitjetpack

import android.app.Application
import android.content.Context
import keijumt.gitjetpack.core.di.CoreComponent
import keijumt.gitjetpack.core.di.CoreComponentProvider
import keijumt.gitjetpack.core.di.CoreModule
import keijumt.gitjetpack.core.di.DaggerCoreComponent

class App : Application(), CoreComponentProvider {

    companion object {
        /**
         * CoreComponentを取得する
         * @param context
         */
        fun coreComponent(context: Context) =
            (context.applicationContext as App).coreComponent
    }

    private val coreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent(this)
}