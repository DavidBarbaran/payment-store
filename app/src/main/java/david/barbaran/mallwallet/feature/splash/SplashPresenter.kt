package david.barbaran.mallwallet.feature.splash

import android.graphics.Bitmap
import david.barbaran.mallwallet.app.MainApplication
import java.io.ByteArrayOutputStream

class SplashPresenter(private val controller: SplashController.View) : SplashController.Presenter {

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