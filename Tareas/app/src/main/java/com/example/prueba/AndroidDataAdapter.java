package com.example.prueba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class AndroidDataAdapter extends RecyclerView.Adapter<AndroidDataAdapter.ViewHolder> {
    private ArrayList<Tarea> arrayList;
    private Context mcontext;

    public AndroidDataAdapter(Context context, ArrayList<Tarea> ts) {
        this.arrayList = ts;
        this.mcontext = context;
    }

    @Override
    public AndroidDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AndroidDataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nombreTareaTV.setText(arrayList.get(i).getNombre());
        viewHolder.fechaTareaTV.setText(arrayList.get(i).getStringFecha());
        viewHolder.horaTareaTV.setText(arrayList.get(i).getHora().toString());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTareaTV;
        private TextView fechaTareaTV;
        private TextView horaTareaTV;

        public ViewHolder(View v) {
            super(v);

            nombreTareaTV = v.findViewById(R.id.nombreTarea);
            fechaTareaTV = v.findViewById(R.id.fechaTarea);
            horaTareaTV = v.findViewById(R.id.horaTarea);
        }
    }
}
