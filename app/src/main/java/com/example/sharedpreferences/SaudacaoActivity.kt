package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val saudacaoPercistencia = this.getSharedPreferences("saudacao",Context.MODE_PRIVATE)

        val nome = saudacaoPercistencia.getString("nome","")
        val tratamento = saudacaoPercistencia.getString("tratamento","")

        if (tratamento.equals("Sem Tratamento") or tratamento.isNullOrEmpty()){
            lbSaudacao.text = nome
        }
        else{
            "$tratamento $nome".also { lbSaudacao.text = it }
        }

    }
}