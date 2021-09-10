package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var buttomnavigation:BottomNavigationView
    lateinit var toolbar:Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttomnavigation=findViewById(R.id.bottomnavigation)
        toolbar=findViewById(R.id.toolbar)
        setTitle("Application Programming Interface")
        setSupportActionBar(toolbar)


        buttomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.api1->{
                    val fragment = ap2()
                    supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
                    true

                }
                R.id.api2->{
                    val fragment = ap1()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
//                     val fragment = ap2()
//                    supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
//                    true
                }
                R.id.api3->{
                    val fragment =ap3()
                    supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
                    true
                }
                else -> false
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.context, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home->{
                if(R.id.home.equals("")){
                val fragment = ap2()
                supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
                true

            }else{
                    val fragment = ap3()
                    supportFragmentManager.beginTransaction().replace(R.id.frame,fragment).commit()
                    true
                }

                }
        }
        return true
    }
}
