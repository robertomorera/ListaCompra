package com.roberto.listacompra;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by PCCasa on 23/01/2017.
 */

public class ListenerBotones implements View.OnClickListener {

    /**
     * Atributo de contexto de la clase ListenerBotones.
     */
    private Context context;


    /**
     * Constructor de la clase ListenerBotones
     * @param context
     */
    public ListenerBotones(Context context) {
        this.context = context;
    }

    /**
     * Método que escucha los listener de los distintos botones de la aplicacion
     * @param v
     */
    @Override
    public void onClick(View v) {
        Log.d(getClass().getCanonicalName(),"Entrada al listener de los botones de la aplicacion ListaCompra");
        switch(v.getId()){
                //Botón de inicio de la aplicacion.
            case R.id.botonIniciarApp:
                Log.d(getClass().getCanonicalName(),"Se ha pulsado en el botón de inicio de la aplicación");
                //Creamos un intent para pasar a la siguiente actividad.
                Intent intent=new Intent(context,ListadoProductosActivity.class);
                //Iniciamos la actividad ListadoProductosActivity.
                context.startActivity(intent);
                break;


        }
    }
}
