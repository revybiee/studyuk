package io.studyuk.view.practice

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.studyuk.R
import io.studyuk.view.result.ResultActivity
import kotlinx.android.synthetic.main.activity_practice.*

class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        btn_finish.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            // Judul
            .setTitle("Submit Latihan Soal")
            // Pesan yang di tamopilkan
            .setMessage("Apakah anda yakin ingin submit latihan soal ?")
            .setPositiveButton("Ya") { dialogInterface, i ->
                startActivity(Intent(this, ResultActivity::class.java))
                finishAffinity()
            }
            .setNegativeButton("Tidak", { dialog, i ->
                dialog.dismiss()
            })

            .show()

    }
}
