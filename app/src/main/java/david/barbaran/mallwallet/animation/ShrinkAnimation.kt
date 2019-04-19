package david.barbaran.mallwallet.animation

import android.animation.ValueAnimator
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.core.view.animation.PathInterpolatorCompat

class ShrinkAnimation {

    private val interpolator = PathInterpolatorCompat.create(0.455f, 0.030f, 0.515f, 0.955f)
    private val valueAnimatorCircleMain = ValueAnimator.ofFloat(1.0f, 0.6f)

    inner class Builder {

        private var view: View? = null
        private var repeatCount = 2
        private var duration = 525
        private lateinit var onAnimationEnd: () -> Unit

        fun view(view: View) = apply { this.view = view }

        fun repeatCount(repeatCount: Int) = apply { this.repeatCount = repeatCount }

        fun duration(duration: Int) = apply { this.duration = duration }

        fun onEnd(onAnimationEnd: () -> Unit) = apply { this.onAnimationEnd = onAnimationEnd }

        fun build() {
            if (view != null) {
                valueAnimatorCircleMain.repeatCount = repeatCount
                valueAnimatorCircleMain.repeatMode = ValueAnimator.REVERSE
                valueAnimatorCircleMain.interpolator = interpolator
                valueAnimatorCircleMain.duration = duration.toLong()
                valueAnimatorCircleMain.addUpdateListener { animation ->
                    view?.scaleY = animation.animatedValue as Float
                    view?.scaleX = animation.animatedValue as Float
                }
                valueAnimatorCircleMain.doOnEnd {
                    if (::onAnimationEnd.isInitialized) {
                        onAnimationEnd()
                    }
                }
                valueAnimatorCircleMain.start()
            }

        }
    }
}