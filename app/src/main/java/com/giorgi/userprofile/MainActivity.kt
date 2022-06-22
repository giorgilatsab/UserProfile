package com.giorgi.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.giorgi.userprofile.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            valid()
        }
        binding.buttonClear.setOnLongClickListener{
            clear()
            true
        }


    }
    fun valid(){
        if(checkEdit(binding.edEmail) || checkEdit(binding.edFirstname)
            || checkEdit(binding.edUsername) || checkEdit(binding.edAge))
        {  Toast.makeText(this,"შეავსეთ ყველა ველი",
                Toast.LENGTH_SHORT).show() }

        else if (binding.edUsername.text.toString().length < 10){
            Toast.makeText(this,"username გრაფაში არ უნდა იყოს 10 სიმბოლოზე ნაკლები",
                Toast.LENGTH_SHORT).show() }

         else if (!Patterns.EMAIL_ADDRESS.matcher(binding.edEmail.text.toString()).matches()){
            Toast.makeText(this,"email გრაფაში ჩაწერეთ ვალიდური მაილი",
                Toast.LENGTH_SHORT).show() }

        else if (binding.edAge.text.toString().toInt() <= 0)  {
            Toast.makeText(this,"Age გრაფაში ჩაწერეთ ნატურალური რიცხვი",
                Toast.LENGTH_SHORT).show() }
    }


    fun checkEdit(value:EditText):Boolean {   // ამოწმებს Edittext ცარიელია თუ არა 
        return value.text.isEmpty()
    }


    fun clear(){
        binding.edUsername.setText("")
        binding.edFirstname.setText("")
        binding.edEmail.setText("")
        binding.edAge.setText("")
    }
}