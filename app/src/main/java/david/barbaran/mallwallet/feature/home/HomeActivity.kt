package david.barbaran.mallwallet.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import david.barbaran.mallwallet.R
import david.barbaran.mallwallet.util.DrawableAlwaysCrossFadeFactory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    val imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2f/Alesso_profile.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
        Thread {
            Thread.sleep(250)
            runOnUiThread {
                Glide.with(this).load(imageUrl)
                    .transition(DrawableTransitionOptions.with(DrawableAlwaysCrossFadeFactory()))
                    .apply(RequestOptions.circleCropTransform()).into(profileImage)
            }
        }.start()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}
