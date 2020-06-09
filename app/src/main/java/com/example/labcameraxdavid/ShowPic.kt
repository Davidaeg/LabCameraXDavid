package com.example.labcameraxdavid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_pic.*


class ShowPic : AppCompatActivity() {
    private var path = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_pic)

        val imageV = findViewById<ImageView>(R.id.imageView2)

        val message:String = intent.getStringExtra("message")

         path = message.substring(7)

       // val media = "/storage/emulated/0/Android/media/com.example.labcameraxdavid/LabCameraXDavid/2020-06-08-18-09-10-273.jpg"
        textView.text = "Foto guardada en: "+path;
        if (path !== null) {
            Glide.with(this)
                .load(path)
                .into(imageV)
        } else {
            imageV.setImageResource(R.drawable.ic_launcher_background)
        }
        buttons()
    }


    private fun buttons(){
        button.setOnClickListener {
            val imageUri = Uri.parse("file://"+path)
            val i = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            i.putExtra(Intent.EXTRA_SUBJECT, "Consulta COVID-19 ")
            i.putExtra(Intent.EXTRA_TEXT,"sintomas por imagen")
            i.putExtra(Intent.EXTRA_STREAM, imageUri)
            i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(i, "Seleccione una aplicación"))

        }

    }
}
