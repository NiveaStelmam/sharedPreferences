package com.example.testesharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testesharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }

    override fun onStop(){ // persistencia de dados
        super.onStop()

        var preferencia = getPreferences(MODE_PRIVATE)
        val preferencia_editor = preferencia.edit()
        preferencia_editor.putString("campo", binding.editText.text.toString())
        preferencia_editor.putInt("inteiro", 2)
        preferencia_editor.apply()
    }

    override fun onStart() { // recuperação de dados
        super.onStart()
        var preferencia = getPreferences(MODE_PRIVATE)
        var campo = preferencia.getString("campo", "")
        var inteiro= preferencia.getInt("inteiro", 2)

        binding.editText.setText(campo)
        binding.editTextNumber.setText(inteiro.toString())


    }

}
