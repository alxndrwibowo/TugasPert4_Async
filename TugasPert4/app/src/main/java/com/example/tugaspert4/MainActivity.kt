package com.example.tugaspert4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnExplicit: Button
    lateinit var btnImplicit: Button
    lateinit var btnData: Button
    lateinit var btnObject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnExplicit = findViewById(R.id.btnExplicit)
        btnImplicit = findViewById(R.id.btnImplicit)
        btnData = findViewById(R.id.btnData)
        btnObject = findViewById(R.id.btnObject)

        btnExplicit.setOnClickListener(this)
        btnImplicit.setOnClickListener(this)
        btnData.setOnClickListener(this)
        btnObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnExplicit -> {
                val intentExplicit = Intent(this@MainActivity, Activity2::class.java)
                startActivity(intentExplicit)
            }
            R.id.btnImplicit -> {
                val intentImplicit = Intent(Intent.ACTION_DIAL, Uri.parse("tel:085740482440"))
                startActivity(intentImplicit)
            }
            R.id.btnData -> {
                val intentData = Intent(this@MainActivity, ActivityData::class.java)
                intentData.putExtra(ActivityData.extraName, "Boy")
                intentData.putExtra(ActivityData.extraAge, 5)
                startActivity(intentData)
            }
            R.id.btnObject -> {
                val person = Person("Ani", 5, "ani@gmail.com", "Bandung")
                val intentObject = Intent(this@MainActivity, ActivityObject::class.java)
                intentObject.putExtra(ActivityObject.extraPerson, person)
                startActivity(intentObject)
            }
        }
    }
}