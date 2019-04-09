package david.barbaran.mallwallet.feature.splash

import android.graphics.Bitmap

interface SplashController {
    interface View {
        fun onStartLogin(byteArray: ByteArray)
        fun onStartLoginWithAnimation(byteArray: ByteArray)
    }

    interface Presenter {
        fun processImage(bitmap : Bitmap)
    }
}