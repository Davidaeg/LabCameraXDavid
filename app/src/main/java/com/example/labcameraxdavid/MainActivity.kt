package com.example.labcameraxdavid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val message = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switches()
        buttons()
    }


    fun switches(){
        sw_fiebre.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("fiebre")}
            else {message.remove("fiebre")}
        }
        sw_tos.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("tos")}
            else {message.remove("tos")}
        }
        sw_cansancio.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("cansancio")}
            else {message.remove("cansancio")}
        }
        sw_gusto.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("gusto")}
            else {message.remove("gusto")}
        }
        sw_migranna.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("migraña")}
            else {message.remove("migraña")}
        }
        sw_olfato.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked) {message.add("olfato")}
            else {message.remove("olfato")}
        }
    }

    fun buttons(){
        btn_sendInfo.setOnClickListener {
            var nombre  = editText.text
            if(message.isEmpty()){
                Toast.makeText(baseContext, "Seleccione Sintomas", Toast.LENGTH_SHORT).show()
            }else{
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta COVID-19 "+editText.text )
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Sintomas: "+message.toString())
                startActivity(Intent.createChooser(emailIntent, "Seleccione una aplicación"))
            }

        }
        btn_sendFoto.setOnClickListener{
            val intent = Intent(this, TakePic::class.java)
            startActivity(intent)

        }
    }
}// Set an checked change listener for switch button


