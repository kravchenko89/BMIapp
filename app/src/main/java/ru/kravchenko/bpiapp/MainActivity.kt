package ru.kravchenko.bpiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight_edit_text: EditText = findViewById(R.id.weight_edit_text)
        val calculate_button: Button = findViewById(R.id.calculate_button)
        val height_edit_text: EditText = findViewById(R.id.height_edit_text)
        val bmi_text_view: TextView = findViewById(R.id.bmi_text_view)
        val bmi_image_view: ImageView = findViewById(R.id.bmi_image_view)

        calculate_button.setOnClickListener {
            val weight = weight_edit_text.text.toString().toFloat()
            val height = height_edit_text.text.toString().toFloat()

            val myBM = weight / (height * height)

            bmi_text_view.text = myBM.toString()

            if (myBM < 18.5) {
                    bmi_image_view.setImageResource(R.drawable.ic_underweight)
                }
            else if (myBM >= 18.5 && myBM < 24.9) {
                bmi_image_view.setImageResource(R.drawable.healthy)
            }else if (myBM >= 24.9 && myBM < 29.9) {
                bmi_image_view.setImageResource(R.drawable.ic_overweight)
            }else if (myBM >= 29.9) {
                bmi_image_view.setImageResource(R.drawable.obesity)
            }
        }
    }
}