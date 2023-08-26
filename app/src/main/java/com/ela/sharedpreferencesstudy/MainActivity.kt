package com.ela.sharedpreferencesstudy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ela.sharedpreferencesstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cor = ""

    companion object{
        const val ARQUIVO_PREFERENCIAS = "ArquivoPreferencias"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cor1.setOnClickListener(){
            cor = "#2E7D32"
            salvar(cor)
        }
        binding.cor2.setOnClickListener(){
            cor = "#C62828"
            salvar(cor)
        }
        binding.cor3.setOnClickListener(){
            cor = "#F9A825"
            salvar(cor)
        }
        binding.cor4.setOnClickListener(){
            cor = "#1565C0"
            salvar(cor)
        }
    }
    private fun salvar(cor:String){
        binding.btTrocarCorFundo.setOnClickListener(){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            val preferencias = getSharedPreferences(ARQUIVO_PREFERENCIAS, MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.apply()
        }
    }
}