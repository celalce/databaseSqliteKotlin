package com.celalalbayrak.sqlitekotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.celalalbayrak.sqlitekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


            }
        val context = this
            var db = DatabaseHelper(context)
            binding.btnkaydet.setOnClickListener {
                var etadsoyad = binding.etadsoyad.text.toString()
                var etyas = binding.etyas.text.toString()
                if (etadsoyad.isNotEmpty() && etyas.isNotEmpty()) {
                    var kullanici = kullanici(etadsoyad,etyas.toInt() )
                    db.insertData(kullanici)
                }else{
                    Toast.makeText(applicationContext,"lütfen Boş alanları doldurunuz", Toast.LENGTH_LONG).show()
                }
        }
    }
}