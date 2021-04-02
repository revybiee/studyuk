package io.studyuk.view.login

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import io.studyuk.R
import io.studyuk.utils.makeStatusBarTransparent
import io.studyuk.view.main.MainActivity
import io.studyuk.view.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var listAccount: List<String> = arrayListOf("rere", "ezra")
    var pass: String = "12345"
    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreference = getSharedPreferences("Study", Context.MODE_PRIVATE)

        txt_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btn_login.setOnClickListener {
            val finder = listAccount.filter {
                it == et_username.text.toString()
            }

            if (finder.isNotEmpty() && et_password.text.toString() == pass){
                val intent = Intent(this, MainActivity::class.java)
                val editor = sharedPreference.edit()
                editor.putString("name", et_username.text.toString())
                editor.apply()
                startActivity(intent)
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
        .setMessage("Username atau password salah")
        .setPositiveButton("Ok", { dialogInterface, i ->
            dialogInterface.dismiss()
        })

        .show()

    }
}
