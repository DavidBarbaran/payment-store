package david.barbaran.mallwallet.animation

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import david.barbaran.mallwallet.R

class BounceAnimation(context: Context) {

    private var animation = AnimationUtils.loadAnimation(context, R.anim.bounce_animation)

    private class MyBounceInterpolator(private val amplitude: Double, private val frequency: Double) : Interpolator {

        override fun getInterpolation(input: Float): Float {
            return (-1 * Math.pow(Math.E, -input / amplitude) *
                    Math.cos(frequency * input) + 1).toFloat()
        }
    }

    inner class Builder {

        private var amplitude = 0.12
        private var frequency = 15.0
        private var startOffset = 0L

        fun amplitude(amplitude: Double) = apply { this.amplitude = amplitude }

        fun frequency(frequency: Double) = apply { this.frequency = frequency }

        fun startOffset(startOffset: Long) = apply { this.startOffset = startOffset }

        fun build(): Animation {
            this@BounceAnimation.animation.startOffset = startOffset
            animation.interpolator = MyBounceInterpolator(amplitude, frequency)
            return this@BounceAnimation.animation
        }
    }
}