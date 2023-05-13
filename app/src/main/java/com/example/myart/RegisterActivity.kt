package com.example.myart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var _nom_usu: EditText
    lateinit var _ape_usu: EditText
    lateinit var _tip_usu: EditText
    lateinit var _tel_usu: EditText
    lateinit var btnlogin: Button
    lateinit var tvlogin: TextView
    lateinit var btn_next_register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        _nom_usu = findViewById(R.id.nom_usu)
        _ape_usu = findViewById(R.id.ape_usu)
        _tip_usu = findViewById(R.id.tip_usu)
        _tel_usu = findViewById(R.id.tel_usu)
        btnlogin = findViewById(R.id.btn_login)
        tvlogin = findViewById(R.id.tv_login)
        btn_next_register = findViewById(R.id.btn_next)

        btn_next_register.setOnClickListener{
            //obtener texto
            val nom_usu = _nom_usu.text.toString()
            val ape_usu = _ape_usu.text.toString()
            val tip_usu = _tip_usu.text.toString()
            val tel_usu = _tel_usu.text.toString()

            if (nom_usu.isEmpty() || ape_usu.isEmpty() || tip_usu.isEmpty() || tel_usu.isEmpty()){
                Toast.makeText(this, "Pleace, fill all details.", Toast.LENGTH_SHORT).show()
            }else{
                val i = Intent(this@RegisterActivity, RegisterNextActivity::class.java)
                i.putExtra("nom_usu",nom_usu)
                i.putExtra("ape_usu",ape_usu)
                i.putExtra("tip_usu",tip_usu)
                i.putExtra("tel_usu",tel_usu)
                startActivity(i)
                finish()
                /*  EXTRAER VARIABLES PARA HACER LA INSERCIÓN

                val usu_usu = usu_usu.text.toString()
                val cor_usu = cor_usu.text.toString()
                val con_usu = con_usu.text.toString()

                val user= Usuario(usu_usu,"","",cor_usu,"",3,con_usu,this,"insert",usu_usu)

                if (usu_usu.isEmpty() || con_usu.isEmpty() || con_usu.isEmpty()){
                    Toast.makeText(this, "Pleace, fill all details.", Toast.LENGTH_SHORT).show()
                }else{
                    user.executeService("http://192.168.80.18/MyArt/Usuario.php")
                    //Toast.makeText(this, "Register succesfully.", Toast.LENGTH_SHORT).show()
                    val i = Intent(this, MainActivity::class.java)
                    //startActivity(i)

                }*/
            }

        btnlogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        tvlogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        }
    }
}
