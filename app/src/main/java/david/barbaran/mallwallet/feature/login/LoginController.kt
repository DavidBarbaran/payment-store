package david.barbaran.mallwallet.feature.login

import android.content.Intent
import android.graphics.Bitmap

interface LoginController {
    interface View {
        fun onLoadImageSuccessful(bitmap: Bitmap)
        fun showAnimation()
    }

    interface Presenter {
        fun getAndProcessImage(intent : Intent)
        fun evaluateAnimation()
    }
}