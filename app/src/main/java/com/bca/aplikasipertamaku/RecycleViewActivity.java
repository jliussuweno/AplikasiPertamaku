package com.bca.aplikasipertamaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bca.aplikasipertamaku.adapter.SimpleAdapter;
import com.bca.aplikasipertamaku.delegate.IGeneralCallback;
import com.bca.aplikasipertamaku.model.People;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity implements IGeneralCallback {

    RecyclerView obj_recyclerview;
//    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        obj_recyclerview = findViewById(R.id.obj_recyclerview);

        //##1
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        obj_recyclerview.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        obj_recyclerview.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)


        List<People> tmpDummyData = new ArrayList<>();

        tmpDummyData.add(new People("Andrew", "20", "Male"));
        tmpDummyData.add(new People("Jeje", "20", "Male"));
        tmpDummyData.add(new People("Brosky", "20", "Male"));
        tmpDummyData.add(new People("Angel", "20", "Female"));
        tmpDummyData.add(new People("Silvi", "20", "Female"));
        tmpDummyData.add(new People("Maria", "20", "Female"));
        final SimpleAdapter tmpAdapter = new SimpleAdapter();
        tmpAdapter.setData(tmpDummyData);
        tmpAdapter.setCallback(this);
        obj_recyclerview.setAdapter(tmpAdapter);


        Button tmpButton = findViewById(R.id.button_clickme);
        tmpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmpAdapter.addData(new People("Andrew", "20", "Male"));
                tmpAdapter.addData(new People("Jeje", "20", "Male"));
                tmpAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void itemPressedCallback(String id, String age, String name, String gender) {
        Log.d("Jeje",  id + age + name + gender);
    }
}