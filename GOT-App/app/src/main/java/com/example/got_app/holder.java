package com.example.got_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder extends RecyclerView.ViewHolder
{
    ImageView img;
    TextView t1,t2;
    public holder(@NonNull View itemView)
    {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img1);
        t1=(TextView)itemView.findViewById(R.id.t1);
        t2=(TextView)itemView.findViewById(R.id.t2);
    }
}
