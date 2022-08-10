package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)
        val data = recuperaDadoArquivo("saudacao")
        val tokenizer = StringTokenizer(data, ":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"

        if (tratamento.equals("Sem Tratamento") or tratamento.isNullOrEmpty()) {
            lbSaudacao.text = nome
        } else {
            "$tratamento $nome".also { lbSaudacao.text = it }
        }
    }

    fun recuperaDadoArquivo(fileName: String): String {
        try {
            val fi = openFileInput(fileName)
            val data = fi.readBytes()
            fi.close()
            data.toString()
            return data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            return ""
        } catch (e: IOException) {
            return ""
        }
    }
}