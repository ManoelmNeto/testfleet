package com.example.fletmaxmobile

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var cnpjInput: EditText
    private lateinit var razaoInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var senhaInput: EditText
    private lateinit var confirmarSenhaInput: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var linkLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        cnpjInput = findViewById(R.id.inputCnpj)
        razaoInput = findViewById(R.id.inputRazao)
        emailInput = findViewById(R.id.inputEmail)
        senhaInput = findViewById(R.id.inputSenha)
        confirmarSenhaInput = findViewById(R.id.inputSenhaConfirma)
        btnCadastrar = findViewById(R.id.btnRegistrar)
        linkLogin = findViewById(R.id.txtIrParaLogin)

        btnCadastrar.setOnClickListener {
            val request = RegisterRequest(
                cnpj = cnpjInput.text.toString(),
                razao_social = razaoInput.text.toString(),
                email = emailInput.text.toString(),
                password = senhaInput.text.toString(),
                password_confirmation = confirmarSenhaInput.text.toString()
            )

            RetrofitClient.api.register(request).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@RegisterActivity, "Registrado com sucesso!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    } else {
                        Toast.makeText(this@RegisterActivity, "Erro no registro", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Falha: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

        linkLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
