package com.bca.aplikasipertamaku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bca.aplikasipertamaku.model.People;
import com.google.gson.Gson;

public class WebviewActivity extends AppCompatActivity {

    TextView tv_jeje;
    Button btn_brosky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        tv_jeje = findViewById(R.id.tv_1);
        tv_jeje.setText("String = " + getIntent().getStringExtra("Jeje"));
        btn_brosky = findViewById(R.id.btn_brosky);

        Gson gson = new Gson();
        People people = gson.fromJson(getIntent().getStringExtra("Jeje"), People.class);
        tv_jeje.setText("String = " + people.getAge());


        btn_brosky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmpIntent = new Intent();
                tmpIntent.putExtra("BROSKY", "HAHA");
                setResult(100, tmpIntent);
                finish();
            }
        });
//        finishActivity(100);
//        Intent tmpIntent = new Intent();
//        tmpIntent.putExtra("BROSKY", "HAHA");
//        setResult(100, tmpIntent);
////        setIntent(tmpIntent);
//        finish();

//        parcelabel
//        tv_jeje.setText("String = " + getIntent().getStringExtra("Jeje") + "Int = " + getIntent().getIntExtra("Jeje2", 0));

//        getIntent().getStringExtra("Jeje");
//        getIntent().getIntExtra("Jeje2", 0);
    }
}