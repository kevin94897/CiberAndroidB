package com.example.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

//https://www.viralandroid.com/2016/05/android-recyclerview-example.html

public class MainActivity extends AppCompatActivity {

    private int NRO_TAREAS=10; //Cantidad de tareas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se crea la lista de tareas
        ArrayList<Tarea> ts = creaListaTareas(NRO_TAREAS);
        //Y luego se imprime
        imprimeListaTareas(ts);

        inicializaRecyclerView(ts);
    }

    //Crea la lista de Tareas
    public ArrayList<Tarea> creaListaTareas(int ntareas) {
        ArrayList<Tarea> tareas = new ArrayList<>();

        String nombre;
        Date fecha;
        Time hora;
        for(int i=0; i<ntareas; i++) {
            nombre = "Tarea #" + (i+1);
            fecha = new Date();  //Le asignamos fecha
            long  tiempo = (long) (100000000.0*Math.random()); //Tiempo sera un valor aleatorio
            hora  = new Time(tiempo);
            //Instanciamos el objeto con los valores anteriores
            Tarea t = new Tarea(nombre,fecha,hora);
            //Se agrega al arreglo
            tareas.add(t);
        }

        return tareas;
    }

    //Imprime el arreglo de Tareas
    public void imprimeListaTareas(ArrayList<Tarea> t) {
        int l = t.size();

        for(int i=0; i<l; i++) {
            System.out.println((i+1) + ": " + t.get(i).getNombre() + " " + t.get(i).getStringFecha() + " " + t.get(i).getHora());
        }
    }

    private void inicializaRecyclerView(ArrayList<Tarea> ts) {
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        //RecyclerView.LayoutManager lyMngr= new GridLayoutManager(getApplicationContext(),2);
        LinearLayoutManager lyMngr= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lyMngr);

        AndroidDataAdapter adp = new AndroidDataAdapter(getApplicationContext(), ts);
        rv.setAdapter(adp);

    }


}
