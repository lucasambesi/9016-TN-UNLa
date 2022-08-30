package com.example.clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExamenAdapter extends RecyclerView.Adapter<ExamenAdapter.ExamenViewHolder> {

    private List<Examen> examenes;
    private OnItemClickListener onItemClickListener;

    public ExamenAdapter(List<Examen> examenes, OnItemClickListener onItemClickListener) {
        this.examenes = examenes;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ExamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemExamen = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_examen, parent, false);
        return new ExamenViewHolder(itemExamen);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenViewHolder holder, int position) {
        holder.tvMateria.setText(examenes.get(position).getMateria());
        holder.tvFecha.setText(examenes.get(position).getFecha());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onItemClickListener.onItemClickListener(examenes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return examenes.size();
    }

    public class ExamenViewHolder extends RecyclerView.ViewHolder {
        TextView tvMateria;
        TextView tvFecha;

        public ExamenViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMateria = itemView.findViewById(R.id.tvMateria);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }
    }

    interface OnItemClickListener{
        void onItemClickListener(Examen examen);
    }
}
