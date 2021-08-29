package ru.kravchenko.bpiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    val weight_edit_text: EditText = findViewById(R.id.weight_edit_text)
    val calculate_button: Button = findViewById(R.id.calculate_button)
    val height_edit_text: EditText = findViewById(R.id.height_edit_text)
    val bmi_text_view: TextView = findViewById(R.id.bmi_text_view)
    val bmi_image_view: ImageView = findViewById(R.id.bmi_image_view)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button.setOnClickListener {
            if (weight_edit_text.text.isNotEmpty() && height_edit_text.text.isNotEmpty()) {
                calculateBMI()
            }else {
                Toast.makeText(this, "enter the needed fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun calculateBMI() {
        val weight = weight_edit_text.text.toString().toFloat()
        val height = height_edit_text.text.toString().toFloat()

        val myBM = weight / (height * height)

        bmi_text_view.text = myBM.toString()

        if (myBM < 18.5) {
            bmi_image_view.setImageResource(R.drawable.ic_underweight)
        } else if (myBM >= 18.5 && myBM < 24.9) {
            bmi_image_view.setImageResource(R.drawable.healthy)
        } else if (myBM >= 24.9 && myBM < 29.9) {
            bmi_image_view.setImageResource(R.drawable.ic_overweight)
        } else if (myBM >= 29.9) {
            bmi_image_view.setImageResource(R.drawable.obesity)
        }
    }
}