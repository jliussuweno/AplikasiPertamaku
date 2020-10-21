package com.bca.aplikasipertamaku.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bca.aplikasipertamaku.R;

public class Simple2ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_1;
    TextView tv_2;
    TextView tv_3;
    View parent;

    public Simple2ViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;

        tv_1 = itemView.findViewById(R.id.tv_simple1);
        tv_2 = itemView.findViewById(R.id.tv_simple2);
        tv_3 = itemView.findViewById(R.id.tv_simple3);
    }

    public void setData(String name, String age, String gender) {
        tv_1.setText(name);
        tv_2.setText(age);
        tv_3.setText(gender);
    }

    public View getView(){
        return parent;
    }
}
