package ru.devivanov.modulesdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.devivanov.core_api.dto.Item
import ru.devivanov.modulesdagger.databinding.ActivityMainBinding
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Получаем все, что есть в БД
        App.instance.itemsDao.getItems().observe(this) { list ->
            binding.tv.text = list.joinToString {
                "${it.id} : ${it.title}"
            }
        }
        //По нажатии на кнопку кладем БД то, что было в EditText
        binding.button.setOnClickListener {
            Executors.newSingleThreadExecutor().execute {
                val text = binding.editText.text.toString()
                App.instance.itemsDao.insertItem(Item(title = text))
            }
        }
    }
}