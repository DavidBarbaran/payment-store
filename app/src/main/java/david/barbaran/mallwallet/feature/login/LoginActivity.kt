package david.barbaran.mallwallet.feature.login

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import david.barbaran.mallwallet.R
import david.barbaran.mallwallet.animation.BounceAnimation
import david.barbaran.mallwallet.animation.moveViewToScreenCenter
import david.barbaran.mallwallet.animation.shrinkAnimation
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class LoginActivity : AppCompatActivity(), LoginController.View {

    private val presenter: LoginPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.getAndProcessImage(intent)
        initView()
    }

    private fun initView() {
        googleSignInButton.setOnClickListener {
            loadView.visibility = View.VISIBLE
            facebookSignInButton.visibility = View.INVISIBLE
            googleSignInButton.startAnimation {
                moveViewToScreenCenter(windowManager, container, googleSignInButton) { shrinkAnimation(it) }
            }
        }
    }

    override fun onEnterAnimationComplete() {
        presenter.evaluateAnimation()
    }

    override fun onLoadImageSuccessful(bitmap: Bitmap) {
        logoImage.setImageBitmap(bitmap)
    }

    override fun showAnimation() {
        termsLinear.visibility = View.VISIBLE
        welcomeLinear.visibility = View.VISIBLE
        googleSignInButton.startAnimation(BounceAnimation(this).Builder().build())
        facebookSignInButton.startAnimation(BounceAnimation(this).Builder().startOffset(100).build())
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}