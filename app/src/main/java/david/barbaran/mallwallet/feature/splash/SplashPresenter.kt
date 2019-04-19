package david.barbaran.mallwallet.feature.splash

import android.graphics.Bitmap
import david.barbaran.domain.interactor.CheckVersionUseCase
import david.barbaran.mallwallet.BuildConfig
import david.barbaran.mallwallet.app.MainApplication
import kotlinx.coroutines.*
import java.io.ByteArrayOutputStream

class SplashPresenter(
    private val controller: SplashController.View,
    private val checkVersionUseCase: CheckVersionUseCase
) : SplashController.Presenter {

    private val myScope = CoroutineScope(Dispatchers.Main)

    override fun checkVersion() {
        /*myJob = CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                checkVersionUseCase.checkVersion().await().let {
                    Log.e("checkVersion","${it.lastVersionSupported}")
                }
            }
        }
        */

        myScope.launch  {
            val checkVersion = withContext(Dispatchers.IO) {
                checkVersionUseCase.checkVersion().await()
            }
            if (checkVersion.lastVersionSupported > BuildConfig.VERSION_CODE){

            }
        }

        /*
        GlobalScope.launch{
            checkVersionUseCase.checkVersion().await().let {
                Log.e("checkVersion","${it.lastVersionSupported}")
            }
        }*/
    }

    override fun processImage(bitmap: Bitmap) {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val arrayByteImage = stream.toByteArray()
        if (MainApplication.isApplicationVisible) {
            controller.onStartLoginWithAnimation(arrayByteImage)
        } else {
            controller.onStartLogin(arrayByteImage)
        }
    }
}