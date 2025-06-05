package com.example.fletmaxmobile

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fletmaxmobile.R

class RegisterActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<TextView>(R.id.tvJaTemConta).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        findViewById<Button>(R.id.btnCadastrar).setOnClickListener {
            Toast.makeText(this, "Cadastro efetuado (simulação)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterActivity> {
        override fun createFromParcel(parcel: Parcel): RegisterActivity {
            return RegisterActivity(parcel)
        }

        override fun newArray(size: Int): Array<RegisterActivity?> {
            return arrayOfNulls(size)
        }
    }
}
