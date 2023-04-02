package com.example.codingmaster;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrCode extends AppCompatActivity {

    AppCompatButton sscanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ImageView imageCode=findViewById(R.id.imageCode);
        sscanner = findViewById(R.id.scanner);
        sscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(qrCode.this, scannedBarcode.class));
            }
        });

        // for get data for the edit text
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String numCart ="";
        if(bundle != null){
            numCart = bundle.getString("1");
            Toast.makeText(this, numCart, Toast.LENGTH_SHORT).show();

        }

        //initializing MultiFormatWriter for QR code
        MultiFormatWriter mWriter = new MultiFormatWriter();
        try {
            //BitMatrix class to encode entered text and set Width & Height
            BitMatrix mMatrix = mWriter.encode(numCart, BarcodeFormat.QR_CODE, 400, 400);
            BarcodeEncoder mEncoder = new BarcodeEncoder();
            Bitmap mBitmap = mEncoder.createBitmap(mMatrix);//creating bitmap of code
            imageCode.setImageBitmap(mBitmap);//Setting generated QR code to imageView
            // to hide the keyboard
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
          //  manager.hideSoftInputFromWindow(numCart.getApplicationWindowToken(), 0);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}