package com.example.agenda;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContactos;
    ArrayList<Contacto> items;
    AdapterContacto adapterContacto;

    final static int REQUEST_CODE_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContactos = findViewById(R.id.rvContactos);

        items = new ArrayList<>();
        loadItems();

        adapterContacto = new AdapterContacto(items);

        rvContactos.setAdapter(adapterContacto);

        rvContactos.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadItems() {
        Contacto contacto1 = new Contacto("Rafael Pineda", "Dell", "987654321");

        items.add(contacto1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, Edit.class); //pto de llegada y destino

                //MainActivity estara esperando un resultado
                startActivityForResult(intent, REQUEST_CODE_MAIN);

                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_MAIN && resultCode == RESULT_OK) {

            String pJSON = data.getStringExtra("contacto");
            if (pJSON != null) {
                Gson gson = new Gson();
                Contacto p = gson.fromJson(pJSON, Contacto.class);
                items.add(p);
            }

            //Se le notifica que han habido cambios al adapter
            adapterContacto.notifyDataSetChanged();
        }
    }
}
