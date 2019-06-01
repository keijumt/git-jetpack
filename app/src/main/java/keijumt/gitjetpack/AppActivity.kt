package keijumt.gitjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.gitjetpack.di.DaggerAppComponent

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inject!!
        DaggerAppComponent
            .builder()
            .coreComponent(App.coreComponent(this))
            .build()
            .inject(this)

        setContentView(R.layout.activity_app)
    }
}
