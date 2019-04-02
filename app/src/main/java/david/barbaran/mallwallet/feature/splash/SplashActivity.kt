package david.barbaran.mallwallet.feature.splash

import android.animation.Animator
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_splash.*
import android.transition.ChangeBounds
import david.barbaran.mallwallet.feature.login.LoginActivity
import david.barbaran.mallwallet.R
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : AppCompatActivity(), SplashController.View, Animator.AnimatorListener {

    private val presenter: SplashPresenter by inject { parametersOf(this) }

    companion object {
        const val KEY_IMAGE = "key_image"
        const val SHARED_ELEMENT_TRANSITION_DURATION = 3000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.sharedElementEnterTransition = ChangeBounds().setDuration(SHARED_ELEMENT_TRANSITION_DURATION)
        lottieAnimationView.addAnimatorListener(this)
    }

    override fun onLoadImageSuccessful(byteArray: ByteArray) {
        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
        intent.putExtra(KEY_IMAGE, byteArray)
        val p1 = Pair(logoImage as View, getString(R.string.transition_logo))
        val p2 = Pair(logoText as View, getString(R.string.transition_title))
        val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@SplashActivity, p1, p2
        ).toBundle()
        startActivity(intent, bundle)
    }

    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
        val bitmap: Bitmap = lottieAnimationView.drawable.toBitmap()
        logoImage.setImageBitmap(bitmap)
        lottieAnimationView.visibility = View.INVISIBLE
        presenter.processImage(bitmap)
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }
}