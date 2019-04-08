package david.barbaran.mallwallet.feature.login

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import david.barbaran.mallwallet.R
import david.barbaran.mallwallet.animation.BounceAnimation
import david.barbaran.mallwallet.animation.ShrinkAnimation
import david.barbaran.mallwallet.feature.home.HomeActivity
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
            parentFacebookButtonView.visibility = View.INVISIBLE
            facebookSignInButton.visibility = View.INVISIBLE
            googleSignInButton.startAnimation {
                ShrinkAnimation().Builder().view(googleSignInButton).repeatCount(7).onEnd {
                    startHome()
                }.build()
            }
        }
    }

    private fun startHome() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val p1 = Pair.create<View?, String?>(googleSignInButton as View, getString(R.string.transition_circle))
        val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@LoginActivity, p1
        ).toBundle()
        startActivity(intent, bundle)
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