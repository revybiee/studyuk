package io.studyuk.view.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.studyuk.R
import io.studyuk.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btn_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
