package david.barbaran.mallwallet.app

import android.app.Application
import david.barbaran.mallwallet.feature.splash.splashModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(splashModule))
    }
}