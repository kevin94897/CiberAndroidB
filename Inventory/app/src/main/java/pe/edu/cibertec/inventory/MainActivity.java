package pe.edu.cibertec.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Vistas
    RecyclerView rvProduct;

    //Modelo - informacion a mostrar
    ArrayList<Product> items;

    //Adaptador
    AdapterProduct adapterProduct;

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



    }

    private void loadItems() {
        Product productLaptop = new Product("Laptop", "Marca Dell", 2);
        Product productCellphone = new Product("Cellphone", "Marca Huawei", 4);

        items.add(productLaptop);
        items.add(productCellphone);

    }
}
