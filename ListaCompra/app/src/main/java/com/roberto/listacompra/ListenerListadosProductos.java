package com.roberto.listacompra;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;

/**
 * Created by PCCasa on 23/01/2017.
 */

public class ListenerListadosProductos implements AdapterView.OnItemClickListener {
    /**
     * Atributo context de la aplicación
     */
    private Context context;

    /**
     * Atributo de booleanos que indican si los checkboxes están habilitados
     * o no.
     */
    private Boolean[] arrayCheckBoxes;

    /**
     * Constructor de la clase ListenerListadosProductos.
     * @param context
     * @param arrayCheckBoxes
     */
    public ListenerListadosProductos(Context context, Boolean[] arrayCheckBoxes) {
        this.context = context;
        this.arrayCheckBoxes = arrayCheckBoxes;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Obtenemos el checkbox de la vista.
        CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkProducto);
        if(arrayCheckBoxes[position]){
            Log.d(getClass().getCanonicalName(),"El checkbox de la posición" +position+" se ha deseleccionado");
            arrayCheckBoxes[position]=false;
            checkBox.setChecked(false);
        }else {
            Log.d(getClass().getCanonicalName(),"El checkbox de la posición" +position+" se ha " + "seleccionado");
            arrayCheckBoxes[position]=true;
            checkBox.setChecked(true);
        }

    }
}
