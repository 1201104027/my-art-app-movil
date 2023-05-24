package com.example.myart

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myart.clases.DbHelper
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myart.clases.Usuario
import com.example.myart.clases.adapters.ContentAdapter
import com.example.myart.data.Content
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var home: ImageView
    lateinit var video: ImageView
    lateinit var image: ImageView
    lateinit var music: ImageView
    lateinit var user: ImageView
    lateinit var upload_resource: ImageView
    private val auth= FirebaseAuth.getInstance()

    /* VARIABLES BLOQUEADAS PORQUE SE ENCUENTRAN EN EL CARD_VIDEO

    lateinit var image_user_resource: ImageView
    lateinit var like: ImageView
    lateinit var comment: ImageView
    lateinit var share: ImageView
     */

    lateinit var search: ImageView
    var log=false
    var DbHelper= DbHelper(this)
    //lateinit var comment_resource: ImageView
    //lateinit var name_user_resource: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home = findViewById(R.id.iv_home)
        video = findViewById(R.id.iv_video)
        image = findViewById(R.id.iv_image)
        music = findViewById(R.id.iv_music)
        user = findViewById(R.id.iv_user)
        upload_resource = findViewById(R.id.iv_upload_resource)

        val contenidoList = intent.getSerializableExtra("contenidoList") as? ArrayList<Content>
        if (contenidoList != null) {
            val recyclerView: RecyclerView = findViewById(R.id.rv_content_container)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            val adapter = ContentAdapter(contenidoList)
            recyclerView.adapter = adapter
        } else {
            Toast.makeText(this, "error.", Toast.LENGTH_SHORT).show()
            // Tratar el caso de lista nula
            // Por ejemplo, mostrar un mensaje de error o realizar alguna otra acción
        }

        /* VARIABLES BLOQUEADAS PORQUE SE ENCUENTRAN EN EL CARD_VIDEO

        image_user_resource = findViewById(R.id.iv_user_resource)
        like = findViewById(R.id.iv_like)
        comment = findViewById(R.id.iv_comment)
        share = findViewById(R.id.iv_share)
        */

        search = findViewById(R.id.iv_search)
        home.setOnClickListener{
            Toast.makeText(this, "Home.", Toast.LENGTH_SHORT).show()
        }
        video.setOnClickListener{
            Toast.makeText(this, "video.", Toast.LENGTH_SHORT).show()
        }
        image.setOnClickListener{
            Toast.makeText(this, "image.", Toast.LENGTH_SHORT).show()
        }
        music.setOnClickListener{
            Toast.makeText(this, "music.", Toast.LENGTH_SHORT).show()
        }
        user.setOnClickListener{

            if(auth.currentUser!=null){
                val i = Intent(this, ProfileActivity::class.java)
                startActivity(i)
            }
            else{
                Toast.makeText(this, "user.", Toast.LENGTH_SHORT).show()
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }

        }

        upload_resource.setOnClickListener{
            Toast.makeText(this, "camera.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, CameraActivity::class.java)
            startActivity(i)
        }

        /* VARIABLES BLOQUEADAS PORQUE SE ENCUENTRAN EN EL CARD_VIDEO

        image_user_resource.setOnClickListener{
            Toast.makeText(this, "profile user resource.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, ProfileActivity::class.java)
            startActivity(i)
        }
        like.setOnClickListener{
            Toast.makeText(this, "like like.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        comment.setOnClickListener{
            Toast.makeText(this, "comment comment.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
        share.setOnClickListener{
            Toast.makeText(this, "share share.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }*/
        search.setOnClickListener{
            Toast.makeText(this, "search.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, SearchActivity::class.java)
            startActivity(i)
        }
    }
}