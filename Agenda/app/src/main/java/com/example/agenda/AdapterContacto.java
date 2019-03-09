package com.example.agenda;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContacto extends RecyclerView.Adapter<AdapterContacto.ContactPrototype> {
    ArrayList<Contacto> items;

    public AdapterContacto(ArrayList<Contacto> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_contact, viewGroup, false);

        ContactPrototype p = new ContactPrototype(view);

        return p;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactPrototype contactPrototype, int i) {
        contactPrototype.tvName.setText(items.get(i).getName());
        contactPrototype.tvCompany.setText(items.get(i).getCompany());
        contactPrototype.tvTelephone.setText(items.get(i).getTelephone());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactPrototype extends RecyclerView.ViewHolder {
        TextView tvName, tvCompany, tvTelephone;

        public ContactPrototype(@NonNull View itemView) {
            super(itemView);

            tvName          = itemView.findViewById(R.id.tvName);
            tvCompany       = itemView.findViewById(R.id.tvCompany);
            tvTelephone     = itemView.findViewById(R.id.tvTelephone);
        }
    }
}
