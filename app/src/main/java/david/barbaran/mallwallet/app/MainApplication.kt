package david.barbaran.mallwallet.app

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import david.barbaran.mallwallet.feature.login.loginModule
import david.barbaran.mallwallet.feature.splash.splashModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application(), LifecycleObserver {

    companion object {
        var isApplicationVisible: Boolean = true
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(splashModule, loginModule))
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        isApplicationVisible = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        isApplicationVisible = true
    }
}