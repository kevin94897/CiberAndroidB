package pe.edu.cibertec.inventory;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

public class ProductActivity extends AppCompatActivity {
    TextInputEditText etName, etDescription, etQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        etName = findViewById(R.id.et_name);
        etDescription = findViewById(R.id.et_description);
        etQuantity = findViewById(R.id.et_quantity);
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
        String desc = etDescription.getText().toString();
        int qty  = Integer.parseInt(etQuantity.getText().toString());

        Product p = new Product(name, desc, qty);

        Intent intent = getIntent(); //Obtenemos el intent

        //TODO: en vez de pasar cada parametro, debera pasar el objeto p (Product)
        //GSON
        //intent.putExtra("product_name", name);
        //intent.putExtra("product_description", desc);
        //intent.putExtra("product_quantity", qty);

        //Pasando el objeto (previa transformacion con GSon)
        String pstr = new Gson().toJson(p);
        intent.putExtra("product", pstr);

        //Decirle que la operacion fue exitosa y pasarle el intent (informacion que va a retornar)
        setResult(RESULT_OK, intent);

        Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show();

        finish();
        return true;
    }
}
