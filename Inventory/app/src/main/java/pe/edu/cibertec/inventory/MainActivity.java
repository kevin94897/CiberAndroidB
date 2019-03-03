package pe.edu.cibertec.inventory;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Vistas
    RecyclerView rvProduct;

    //Modelo - informacion a mostrar
    ArrayList<Product> items;

    //Adaptador
    AdapterProduct adapterProduct;

    final static int REQUEST_CODE_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        rvProduct = findViewById(R.id.rvProduct);

        //Instanciamos la lista de productos
        items = new ArrayList<>();

        //Cargar la informacion a mostrar
        loadItems();

        //Instanciamos el adapter
        adapterProduct = new AdapterProduct(items);

        //Asignamos el adapter al recyclerView
        rvProduct.setAdapter(adapterProduct);

        //Como se debe mostrar el recyclerview
        rvProduct.setLayoutManager(new LinearLayoutManager(this));


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
                Intent intent = new Intent(this, ProductActivity.class); //pto de llegada y destino
                //Inicializar una actividad (esta forma de ejecutar no espera resultado)
                //startActivity(intent);

                //MainActivity estara esperando un resultado
                startActivityForResult(intent, REQUEST_CODE_MAIN);

                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Valida de donde proviene y el resultado
        if (requestCode == REQUEST_CODE_MAIN && resultCode == RESULT_OK) {
            String name = data.getStringExtra("product_name");
            String desc = data.getStringExtra("product_description");
            int qty = data.getIntExtra("product_quantity", 0);

            Product p = new Product(name, desc, qty);

            items.add(p);
            //Se le notifica que han habido cambios al adapter
            adapterProduct.notifyDataSetChanged();
        }
    }

    private void loadItems() {
        Product productLaptop = new Product("Laptop", "Marca Dell", 2);
        Product productCellphone = new Product("Cellphone", "Marca Huawei", 4);

        items.add(productLaptop);
        items.add(productCellphone);

    }
}
