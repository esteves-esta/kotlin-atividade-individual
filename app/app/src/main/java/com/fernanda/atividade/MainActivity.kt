package com.fernanda.atividade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(component: View){

        var nota1 = campoNota1.text.toString()
        var nota2 = campoNota2.text.toString()

        if (campoNome.text.toString() == "") {
            Toast.makeText(this, "Insira seu nome", Toast.LENGTH_LONG).show()
            return
        }

        val validado1 = validar(nota1, "Nota da continuada")
        val validado2 = if (validado1) validar(nota2, "Nota da integrada") else false

        if(validado1 && validado2){
            val final = (nota1.toInt() * 0.4) + (nota2.toInt() * 0.6)
            resultado.text = "Resultado: ${campoNome.text} sua nota final é $final"
        }
    }

    fun validar(num: String, nomeCampo: String): Boolean {
        if (num == "") {
            resultado.text = "$nomeCampo não pode estar vazio"
            return false
        } else {
            val numero = num.toInt()
            if (numero < 0 || numero > 10) {
                resultado.text = "$nomeCampo deve ser entre 0 e 10"
                return false
            }
            return true
        }
    }


}