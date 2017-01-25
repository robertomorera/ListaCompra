package com.roberto.listacompra;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class ListadoProductosActivity extends AppCompatActivity {
    /**
     * Galeria de imagenes de los productos.
     */
    private static final Integer[] imagenesProductos={R.drawable.tomates,R.drawable.leche,R.drawable.arroz,R.drawable.queso,R.drawable.patatas,R.drawable.salchichas,R.drawable.aceite,R.drawable.aceitunas
    ,R.drawable.pan,R.drawable.pescado,R.drawable.donuts,R.drawable.platanos,R.drawable.manzanas,R.drawable.chocolate,R.drawable.sal,R.drawable.vinagre,R.drawable.lechuga,R.drawable.zanahorias,R.drawable
    .ajos,R.drawable.yogur};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);
        //Cargamos los datos del array de recursos.
        Resources resources=this.getResources();
        String[] textosProductos=resources.getStringArray(R.array.arrayProductos);
        /**
         * Array que indica si el checkBok de cada fila esta seleccionado o no.
         * Al principio estarán todos deseleccionados (valor false).
         */
        Boolean [] arrayChecks= new Boolean[imagenesProductos.length];
        Arrays.fill(arrayChecks,Boolean.FALSE);
        ListView listaProductos=(ListView)findViewById(R.id.lista_productos);
        //Creamos el adaptador del ListView para pasarle los datos.
        ListaProductosAdapter listaProductosAdapter=new ListaProductosAdapter(this,textosProductos,imagenesProductos,arrayChecks);
        //Asociamos el adapter creado a su ListView.
        listaProductos.setAdapter(listaProductosAdapter);
        //Creamos el listener del ListView.
        ListenerListadosProductos listenerListadosProductos=new ListenerListadosProductos(this,listaProductosAdapter.getArrayCheckBoxes());
        //Se lo asociamos al listView su listener.
        listaProductos.setOnItemClickListener(listenerListadosProductos);
    }
}
