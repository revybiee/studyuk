package io.studyuk.view.register

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.studyuk.R
import io.studyuk.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (et_name.text.toString() != ""){
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } else {
                showDialog()
            }
        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            // Judul
            .setTitle("Error !")
            // Pesan yang di tamopilkan
            .setMessage("Semua field harus terisi!")
            .setPositiveButton("Ok") { dialogInterface, i ->
                dialogInterface.dismiss()
            }

            .show()

    }
}
