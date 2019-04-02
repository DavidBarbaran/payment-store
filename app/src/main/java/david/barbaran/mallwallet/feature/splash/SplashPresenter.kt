package david.barbaran.mallwallet.feature.splash

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

class SplashPresenter(private val controller: SplashController.View) : SplashController.Presenter {

    override fun processImage(bitmap: Bitmap) {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val arrayByteImage = stream.toByteArray()
        controller.onLoadImageSuccessful(arrayByteImage)
    }
}