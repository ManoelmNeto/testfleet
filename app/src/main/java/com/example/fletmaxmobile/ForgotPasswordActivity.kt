package com.example.fletmaxmobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        findViewById<TextView>(R.id.tvVoltarLogin).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<Button>(R.id.btnEnviarLink).setOnClickListener {
            Toast.makeText(this, "Link enviado (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}
