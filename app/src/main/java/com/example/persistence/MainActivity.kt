package com.example.persistence

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var tvResult: TextView

    private val prefsName = "UserPrefs"
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        tvResult = findViewById(R.id.tvResult)

        val btnRetrieve: Button = findViewById(R.id.btnRetrieve)
        val btnClear: Button = findViewById(R.id.btnClear)

        // Load existing data
        loadData()

        // Automatically save when text changes
        addAutoSave(etName, "name")
        addAutoSave(etEmail, "email")
        addAutoSave(etPhone, "phone")

        btnRetrieve.setOnClickListener {
            loadData()
        }

        btnClear.setOnClickListener {
            getSharedPreferences(
                prefsName, MODE_PRIVATE
            ).edit().clear().apply()

            isLoading = true
            etName.text.clear()
            etEmail.text.clear()
            etPhone.text.clear()
            isLoading = false

            tvResult.text = "No saved data"

            Toast.makeText(
                this,
                "Data cleared successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun addAutoSave(
        editText: EditText,
        key: String
    ) {
        editText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (!isLoading) {
                    getSharedPreferences(
                        prefsName, MODE_PRIVATE
                    ).edit()
                        .putString(key, s.toString())
                        .apply()

                    showSavedData()
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun loadData() {
        val prefs = getSharedPreferences(
            prefsName, MODE_PRIVATE
        )

        isLoading = true

        etName.setText(prefs.getString("name", ""))
        etEmail.setText(prefs.getString("email", ""))
        etPhone.setText(prefs.getString("phone", ""))

        isLoading = false

        showSavedData()
    }

    private fun showSavedData() {
        val prefs = getSharedPreferences(
            prefsName, MODE_PRIVATE
        )

        val name = prefs.getString("name", "") ?: ""
        val email = prefs.getString("email", "") ?: ""
        val phone = prefs.getString("phone", "") ?: ""

        if (name.isEmpty() && email.isEmpty() &&
            phone.isEmpty()
        ) {
            tvResult.text = "No saved data"
        } else {
            tvResult.text = """
                Saved User Details

                Name: $name
                Email: $email
                Phone: $phone
            """.trimIndent()
        }
    }
}
