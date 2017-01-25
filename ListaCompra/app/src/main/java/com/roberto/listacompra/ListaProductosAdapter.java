package com.roberto.listacompra;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by PCCasa on 23/01/2017.
 */

public class ListaProductosAdapter extends BaseAdapter {

    /**
     * Contexto de la actividad.
     */
    private Context context;

    /**
     * Atributo con el nombre de los productos que se mostraran
     * en su ListView asociado.
     */
    private String[] arrayProductos;

    /**
     * Atributo con las imagenes de los productos que se mostraran
     * en su ListView asociado.
     */
    private Integer[] galeriaImagenes;

    /**
     * Atributo que representa los valores logicos para indicar si los
     * checkboxes están seleccionados o no.
     */
    private Boolean[] arrayCheckBoxes;

    /**
     * Constructor de la clase ListaProductosAdapter
     * @param context
     * @param arrayProductos
     * @param galeriaImagenes
     * @param arrayCheckBoxes
     */
    public ListaProductosAdapter(Context context, String[] arrayProductos,Integer[] galeriaImagenes,Boolean[] arrayCheckBoxes) {
        this.context = context;
        this.arrayProductos = arrayProductos;
        this.galeriaImagenes=galeriaImagenes;
        this.arrayCheckBoxes=arrayCheckBoxes;
    }

    /**
     * Método que devuelve el número de veces que se llamara al método
     * getView()
     * @return
     */
    @Override
    public int getCount() {
        return arrayProductos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Método que devuelve fila inflada para cada elemento
     * de la lista de productos.
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Creamos la vista a devolver.
        View filaInflada=null;
        //Obtenemos una referencia de la actividad.
        Activity activity=(Activity)context;
        //Creamos el objeto LayoutInflater.
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        //Inflamos la vista
        if(convertView==null){
            Log.d(getClass().getCanonicalName(),"Se infla la fila del producto en la posicion "+position);
            //Obtenemos la fila inflada.
            filaInflada=layoutInflater.inflate(R.layout.producto,parent,false);

        }else{
            Log.d(getClass().getCanonicalName(),"Se recicla la fila en la posicion "+position);
            filaInflada=convertView;
        }
        //Obtenemos el ImageView.
        ImageView imagenProducto=(ImageView)filaInflada.findViewById(R.id.imagenProducto);
        //Seteamos la imagen del array de productos.
        imagenProducto.setImageResource(galeriaImagenes[position]);
        //Obtenemos el TextView.
        TextView textoProducto=(TextView)filaInflada.findViewById(R.id.textoProducto);
        //Seteamos el texto del producto.
        textoProducto.setText(arrayProductos[position].toString());
        //Obtenemos el check.
        CheckBox checkProducto=(CheckBox)filaInflada.findViewById(R.id.checkProducto);
        if(arrayCheckBoxes[position]){ //El checkbox está seleccionado.
            Log.d(getClass().getCanonicalName(),"El checkbox de la posición" +position+" está seleccionado");
            checkProducto.setChecked(true);
        }else{ //El checkbox no está seleccionado.
            Log.d(getClass().getCanonicalName(),"El checkbox de la posición" +position+" está deseleccionado");
            checkProducto.setChecked(false);
        }


        return filaInflada;
    }

    /**
     * Devuelve el array con los valores logicos de habilitacion de los checkboxes.
     * @return
     */
    public Boolean[] getArrayCheckBoxes() {
        return arrayCheckBoxes;
    }

    /**
     * Fija el array de valores lógicos de los checkboxes.
     * @param arrayCheckBoxes
     */
    public void setArrayCheckBoxes(Boolean[] arrayCheckBoxes) {
        this.arrayCheckBoxes = arrayCheckBoxes;
    }
}
