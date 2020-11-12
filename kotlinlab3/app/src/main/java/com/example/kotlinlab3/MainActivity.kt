package com.example.kotlinlab3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_choice.setOnClickListener {
            startActivityForResult(Intent(this,MainActivity2::class.java),1);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val c = data?.extras?:return
        if(resultCode==101 && requestCode== 1)
        {
            tv_meal.text= String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                    c.getString("drink"),c.getString("sugar"),c.getString("ice"))
        }
    }
}