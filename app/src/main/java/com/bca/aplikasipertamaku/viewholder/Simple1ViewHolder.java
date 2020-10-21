package com.bca.aplikasipertamaku.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bca.aplikasipertamaku.R;

public class Simple1ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_simple;
    View parent;

    public Simple1ViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        tv_simple = itemView.findViewById(R.id.tv_simple1);
    }

    public void setText(String name){
        tv_simple.setText(name);
    }

    public View getView(){
        return parent;
    }
}
