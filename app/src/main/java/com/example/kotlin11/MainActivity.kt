package com.example.kotlin11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SecondActivity::class.java)

        binding.btnGo.setOnClickListener {
            if (binding.EditText.text.isNotEmpty()) {
                intent.putExtra("text", binding.EditText.text.toString())
                registerForActivityResult.launch(intent)

            } else
                Toast.makeText(this, "Введите данные в поле", Toast.LENGTH_SHORT)
                    .show()
        }

        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            binding.EditText.setText(it.data?.getStringExtra("back"))
        }

    }

}