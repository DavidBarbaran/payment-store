package david.barbaran.mallwallet.feature.login

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import david.barbaran.mallwallet.R
import david.barbaran.mallwallet.feature.splash.SplashActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val b: ByteArray = intent.extras.getByteArray(SplashActivity.KEY_IMAGE)
        val bmp = BitmapFactory.decodeByteArray(b, 0, b.size)
        logoImage.setImageBitmap(bmp)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}