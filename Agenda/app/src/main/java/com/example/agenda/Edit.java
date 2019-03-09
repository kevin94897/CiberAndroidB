package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

public class Edit extends AppCompatActivity {

    TextInputEditText etName, etCompany, etTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etName = findViewById(R.id.et_name);
        etCompany = findViewById(R.id.et_company);
        etTelephone = findViewById(R.id.et_telephone);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.save_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String name = etName.getText().toString();
        String desc = etCompany.getText().toString();
        String telef  = etTelephone.getText().toString();

        Contacto p = new Contacto(name, desc, telef);

        Intent intent = getIntent(); //Obtenemos el intent

        String pstr = new Gson().toJson(p);
        intent.putExtra("contacto", pstr);

        setResult(RESULT_OK, intent);

        Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show();

        finish();
        return true;
    }

}
