package pe.edu.cibertec.inventory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

//Importante heredar de la clase RecyclerView.Adapter<VH>
//ProductPrototype es el ViewHolder
public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductPrototype> {
    ArrayList<Product> items;

    public AdapterProduct(ArrayList<Product> items) {
        this.items = items;
    }

    //Crea la vista en base al prototipo (view holder) por cada celda
    @NonNull
    @Override
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    //Carga la informacion por cada celda de acuerdo a la posicion (i)
    @Override
    public void onBindViewHolder(@NonNull ProductPrototype productPrototype, int i) {

    }

    //Cantidad de registros en el RecyclerView
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductPrototype extends RecyclerView.ViewHolder {
        TextView tvName, tvDescription, tvQuantity;

        public ProductPrototype(@NonNull View itemView) {
            super(itemView);

            tvName          = itemView.findViewById(R.id.tvName);
            tvDescription   = itemView.findViewById(R.id.tvDescription);
            tvQuantity      = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
