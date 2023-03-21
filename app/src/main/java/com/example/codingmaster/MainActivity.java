package com.example.codingmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button for generating QR code
        AppCompatButton btnGenerate = findViewById(R.id.btnGenerate);
        //Text will be entered here to generate QR code
        TextInputEditText etText = findViewById(R.id.numCart);

        btnGenerate.setOnClickListener(v -> {
            //getting text from input text field.
            String myText = etText.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this,qrCode.class);
            intent.putExtra("1",myText);
            startActivity(intent);
        });
    }
}