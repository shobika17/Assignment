package com.example.lauditor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_login_password);
        buttonSubmit = findViewById(R.id.button6);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAndSubmit();
            }
        });
    }




    private void validateAndSubmit() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();


        if (!ValidationUtils.isValidEmail(email)) {
            showPopupMessage("Invalid email id");
            return;
        }

        if (ValidationUtils.isValidPassword(password)) {
            return;
        }
        showPopupMessage("Invalid password. Password must be at least 8 characters long.");
        return;

        // Proceed with submission logic
        // For example, call an API or perform authentication
    }

    private void showPopupMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
