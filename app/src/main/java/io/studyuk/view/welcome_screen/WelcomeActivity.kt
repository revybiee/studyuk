package io.studyuk.view.welcome_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import io.studyuk.R
import io.studyuk.utils.makeStatusBarTransparent
import io.studyuk.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.coroutines.withTimeout

class WelcomeActivity : AppCompatActivity() {

    private var TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        makeStatusBarTransparent()

        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
}
}
