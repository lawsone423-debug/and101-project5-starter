package com.example.apichoice

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var apiChoice: Spinner
    private lateinit var button: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        apiChoice = findViewById(R.id.api_choice)
        button = findViewById(R.id.call_api_button)
        resultText = findViewById(R.id.result_text)

        // Set up API list
        val apis = listOf(
            "https://jsonplaceholder.typicode.com/posts/1",
            "https://randomuser.me/api/",
            "https://pokeapi.co/api/v2/pokemon/pikachu"
        )
        apis.forEachIndexed { index, url ->
            apiChoice.addItem(index, url)
        }

        // Button click handler
        button.setOnClickListener {
            val selectedApi = apiChoice.selectedItem?.toString()
            if (selectedApi != null) {
                resultText.text = "Calling API: $selectedApi"
                try {
                    val response = callApi(selectedApi)
                    resultText.text = "Response: $response"
                } catch (e: Exception) {
                    resultText.text = "Error: ${e.message}"
                }
            }
        }
    }

    private fun callApi(url: String): String {
        // In a real app, use Retrofit, OkHttp, or similar
        // Here we simulate with a simple HTTP call
        return "API response from $url"
    }
}
