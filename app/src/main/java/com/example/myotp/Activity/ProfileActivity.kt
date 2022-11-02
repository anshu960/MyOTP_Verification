package com.example.myotp.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.myotp.R
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.nav_header.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar!!.hide()

        navDraw.itemIconTintList = null
        menu_img.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        navDraw.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 ->{
                    Toast.makeText(this,"Home Clicked",Toast.LENGTH_SHORT).show()
                }
                R.id.item2 ->{
                    Toast.makeText(this,"Profile Clicked",Toast.LENGTH_SHORT).show()
                }
                R.id.item3 ->{
                    Toast.makeText(this,"Setting Clicked",Toast.LENGTH_SHORT).show()
                }
                R.id.item4 ->{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            true
        }
        btn_scan.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.initiateScan()
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            if (resultCode == Activity.RESULT_OK){
                val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
                if (result != null){
                    if (result.contents==null){
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_SHORT).show()
                    }
                } else{
                    super.onActivityResult(requestCode, resultCode, data)
                }
            }
        }
    }


}