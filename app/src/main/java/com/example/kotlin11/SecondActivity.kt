package com.example.kotlin11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin11.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EditText.setText(intent.getStringExtra("text"))

        val intent = Intent(this, MainActivity::class.java)
        binding.btnGo.setOnClickListener {
            if (binding.EditText.text.isNotEmpty()) {
                intent.putExtra("back1", binding.EditText.text.toString())
                setResult(RESULT_OK, Intent().putExtra("back", binding.EditText.text.toString()))
                finish()

            }else{
                Toast.makeText(this, "Введите данные в поле", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
}