package com.example.fletmaxmobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fletmaxmobile.data.model.auth.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var cnpjInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var senhaInput: EditText
    private lateinit var btnLogin: Button
    private lateinit var linkRegistro: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        cnpjInput = findViewById(R.id.inputCnpj)
        emailInput = findViewById(R.id.inputEmail)
        senhaInput = findViewById(R.id.inputSenha)
        btnLogin = findViewById(R.id.btnLogin)
        linkRegistro = findViewById(R.id.txtComeceAqui)

        btnLogin.setOnClickListener {
            val request = LoginRequest(
                cnpj = cnpjInput.text.toString(),
                email = emailInput.text.toString(),
                password = senhaInput.text.toString()
            )

            RetrofitClient.api.login(request).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Login realizado", Toast.LENGTH_SHORT).show()
                        // Salvar token e ir para Home
                    } else {
                        Toast.makeText(this@LoginActivity, "Erro no login", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Falha: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

        linkRegistro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
