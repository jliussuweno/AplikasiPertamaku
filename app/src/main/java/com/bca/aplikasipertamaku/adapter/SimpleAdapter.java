package com.bca.aplikasipertamaku.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bca.aplikasipertamaku.R;
import com.bca.aplikasipertamaku.delegate.IGeneralCallback;
import com.bca.aplikasipertamaku.model.People;
import com.bca.aplikasipertamaku.viewholder.Simple1ViewHolder;
import com.bca.aplikasipertamaku.viewholder.Simple2ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter {

    private  IGeneralCallback callback = null;
    private List<People> arrPeople = new ArrayList<>();

    public void setData(List<People> peoples){
        arrPeople = peoples;
    }

    public void addData(People item){ arrPeople.add(item); }

    public void setCallback(IGeneralCallback callbackDelegate){
        callback = callbackDelegate;
    }

    //Create Tampilan tanpa Data
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder tmpHolder = null;
        switch (viewType){
            case 1 :
                View tmpView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_1, parent, false);
                tmpHolder = new Simple1ViewHolder(tmpView);
                break;
            case 2 :
                View tmpView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_2, parent, false);
                tmpHolder = new Simple2ViewHolder(tmpView2);
                break;
            case 3 :
                break;
        }

        return tmpHolder;
    }

    //Binding Tampilan dengan Data
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        String tmpGender = arrPeople.get(position).getGender();

        if(tmpGender.equalsIgnoreCase("Male")){
            ((Simple1ViewHolder)holder).setText(arrPeople.get(position).getName());
            ((Simple1ViewHolder)holder).getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.itemPressedCallback(position + "", arrPeople.get(position).getAge() , arrPeople.get(position).getName(), arrPeople.get(position).getGender());
                    }
                }
            });
        } else if (tmpGender.equalsIgnoreCase("Female")) {
            ((Simple2ViewHolder)holder).setData(arrPeople.get(position).getName(), arrPeople.get(position).getAge(), arrPeople.get(position).getGender());
            ((Simple2ViewHolder)holder).getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.itemPressedCallback(position + "", arrPeople.get(position).getAge() , arrPeople.get(position).getName(), arrPeople.get(position).getGender());
                    }
                }
            });
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return arrPeople.size();
    }

    @Override
    public int getItemViewType(int position) {
        int tmpReturnViewType = -1;
        String tmpGender = arrPeople.get(position).getGender();
        if(tmpGender.equalsIgnoreCase("Male")){
            tmpReturnViewType = 1;
        } else if (tmpGender.equalsIgnoreCase("Female")) {
            tmpReturnViewType = 2;
        } else {
            tmpReturnViewType = 3;
        }
//        return (arrPeople.get(position).getGender().equalsIgnoreCase("Male") ? 1 : 2);
//        return super.getItemViewType(position);
        return tmpReturnViewType;

    }
}
