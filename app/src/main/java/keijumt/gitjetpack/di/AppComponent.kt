package keijumt.gitjetpack.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import keijumt.gitjetpack.App
import keijumt.gitjetpack.common.ViewModelModule
import keijumt.gitjetpack.data.di.ApiModule
import keijumt.gitjetpack.data.di.DataModule
import keijumt.gitjetpack.data.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        DataModule::class,
        ApiModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}

fun Application.createAppComponent() = DaggerAppComponent.builder()
    .application(this)
    .build()