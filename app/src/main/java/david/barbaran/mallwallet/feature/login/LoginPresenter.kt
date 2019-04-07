package david.barbaran.mallwallet.feature.login

import android.content.Intent
import android.graphics.BitmapFactory
import david.barbaran.mallwallet.feature.splash.SplashActivity

class LoginPresenter(private val controller: LoginController.View) : LoginController.Presenter {

    private var countShowAnimation = 0

    override fun getAndProcessImage(intent: Intent) {
        val bundle = intent.extras
        if (bundle != null) {
            val byteArray: ByteArray? = bundle.getByteArray(SplashActivity.KEY_IMAGE)
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray?.size ?: 0)
            controller.onLoadImageSuccessful(bitmap)
        }
    }

    override fun evaluateAnimation() {
        if (countShowAnimation == 0) {
            countShowAnimation++
            controller.showAnimation()
        }
    }
}