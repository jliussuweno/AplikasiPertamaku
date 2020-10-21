package com.bca.aplikasipertamaku;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bca.aplikasipertamaku.global.GlobalHolder;
import com.bca.aplikasipertamaku.model.People;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    TextView obj_tv1;
    Button obj_btnPindahkeWebViewActivity;
    Button obj_btn2;
    Button obj_btn3;
    Button obj_btn4;

    private static final String TAG  = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //##0. [Mandatory Step] Bind layout with the activity
        setContentView(R.layout.activity_main);

        //##1. Bind Action with View/Object
        obj_tv1 = findViewById(R.id.tv1);
        obj_btnPindahkeWebViewActivity = findViewById(R.id.btn_webview_activity);
        obj_btn2 = findViewById(R.id.btn2);
        obj_btn3 = findViewById(R.id.btn3);
        obj_btn4 = findViewById(R.id.btn4);

        //##2 Pergunakan Object Sesuai kebutuhan
        obj_tv1.setText("Saya Berubah!");

//        People tmpVar = new People();
//        tmpVar.setName("Aang");
//        tmpVar.setAge("20");
//        tmpVar.setGender("Male");
//
//        Gson gson = new Gson();
//        String json = gson.toJson(tmpVar);
//
//        Log.d("Jeje", json);

        //delegation pattern
        //##3 Add Event Click
        obj_btnPindahkeWebViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent tmpIntent = new Intent(getApplicationContext(), WebviewActivity.class);
                Intent tmpIntent = new Intent(MainActivity.this, WebviewActivity.class);

                People tmpVar = new People();
                tmpVar.setName("Aang");
                tmpVar.setAge("20");
                tmpVar.setGender("Male");

                Gson gson = new Gson();
                String json = gson.toJson(tmpVar);

                Log.d("Jeje", json);

                tmpIntent.putExtra("Jeje",json);
                tmpIntent.putExtra("Jeje2",3);
//                startActivity(tmpIntent);
                startActivityForResult(tmpIntent, 100);

//                GlobalHolder.GlobalVariableToBePassed

//                finish();
//                obj_tv1.setText("Button 1 Di Klik!");

            }
        });

        obj_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                obj_tv1.setText("Button 2 Di Klik!");
                //explicit intent
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });

        obj_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                obj_tv1.setText("Button 3 Di Klik!");
                String url = "http://google.com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        obj_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmpIntent = new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(tmpIntent);
//                obj_tv1.setText("Tombol Recycle Presseed");
            }
        });

//        for(int tmpI = 0 ; tmpI <= 10; tmpI++){
//            Log.d(TAG, tmpI + "");
//        }
        Log.d(TAG, "onCreate terbuka");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult terbuka " + requestCode + "_" + resultCode);
        Log.d(TAG, "onActivityResult terbuka " + data.getStringExtra("BROSKY"));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState terbuka");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState terbuka");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart terbuka");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart terbuka");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume terbuka");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause terbuka");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop terbuka");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy terbuka");
    }
}