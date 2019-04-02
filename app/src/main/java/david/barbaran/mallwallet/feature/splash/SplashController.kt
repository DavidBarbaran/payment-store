package david.barbaran.mallwallet.feature.splash

import android.graphics.Bitmap

interface SplashController {
    interface View {
        fun onLoadImageSuccessful(byteArray: ByteArray)
    }

    interface Presenter {
        fun processImage(bitmap : Bitmap)
    }
}