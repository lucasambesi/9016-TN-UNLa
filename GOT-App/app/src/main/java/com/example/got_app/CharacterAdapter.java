package com.example.got_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<holder>
{
    ArrayList<CardCharacterModel> data;
    Context context;
    public CharacterAdapter(ArrayList<CardCharacterModel> data, Context context)
    {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow_character,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, int position)
    {
        final CardCharacterModel temp=data.get(position);

        holder.t1.setText(data.get(position).getHeader());
        holder.t2.setText(data.get(position).getDesc());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
}
