package com.bca.aplikasipertamaku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bca.aplikasipertamaku.eventHandler.DefaultClickListener;

public class MainActivity extends AppCompatActivity {

    TextView obj_tv1;
    Button obj_btn1;
    Button obj_btn2;
    Button obj_btn3;

    private static final String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //##0. [Mandatory Step] Bind layout with the activity
        setContentView(R.layout.activity_main);

        //##1. Bind Action with View/Object
        obj_tv1 = findViewById(R.id.tv1);
        obj_btn1 = findViewById(R.id.btn1);
        obj_btn2 = findViewById(R.id.btn2);
        obj_btn3 = findViewById(R.id.btn3);

        //##2 Pergunakan Object Sesuai kebutuhan
        obj_tv1.setText("Saya Berubah!");

        //delegation pattern
        //##3 Add Event Click
        obj_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj_tv1.setText("Saya Di Klik!");
            }
        });

        obj_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"TEST Logging");
            }
        });

        for(int tmpI = 0 ; tmpI <= 10; tmpI++){
            Log.d(TAG, tmpI + "");
        }



    }
}