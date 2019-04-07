package david.barbaran.mallwallet.animation

import android.animation.ValueAnimator
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.core.view.animation.PathInterpolatorCompat

fun moveViewToScreenCenter(windowManager: WindowManager, parentView: View, view: View, onAnimationEnd: () -> Unit) {
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    val statusBarOffset = dm.heightPixels - parentView.measuredHeight

    val originalPos = IntArray(2)
    view.getLocationOnScreen(originalPos)

    var xDest = dm.widthPixels / 2
    xDest -= view.measuredWidth / 2
    val yDest = dm.heightPixels / 2 - view.measuredHeight / 2 - statusBarOffset

    val anim = TranslateAnimation(
        0f, (xDest - originalPos[0]).toFloat(),
        0f, (yDest - originalPos[1]).toFloat()
    )
    anim.duration = 500
    anim.fillAfter = true
    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            onAnimationEnd()
        }

        override fun onAnimationStart(animation: Animation?) {
        }
    })
    view.startAnimation(anim)
}

fun shrinkAnimation(view: View) {
    val interpolator = PathInterpolatorCompat.create(0.455f, 0.030f, 0.515f, 0.955f)
    val valueAnimatorCircleMain = ValueAnimator.ofFloat(1.0f, 0.6f)
    valueAnimatorCircleMain.repeatCount = ValueAnimator.INFINITE
    valueAnimatorCircleMain.repeatMode = ValueAnimator.REVERSE
    valueAnimatorCircleMain.interpolator = interpolator
    valueAnimatorCircleMain.duration = 525
    valueAnimatorCircleMain.addUpdateListener { animation ->
        view.scaleY = animation.animatedValue as Float
        view.scaleX = animation.animatedValue as Float
    }
    valueAnimatorCircleMain.start()
}