package keijumt.gitjetpack.di

import android.content.Context
import dagger.Module
import dagger.Provides
import keijumt.gitjetpack.App
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: App): Context {
        return app
    }
}