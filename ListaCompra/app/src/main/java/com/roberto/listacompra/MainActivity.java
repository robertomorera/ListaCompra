package com.roberto.listacompra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos la referencia del boton de inicio de app.
        Button botonInicioApp=(Button)findViewById(R.id.botonIniciarApp);
        //Creamos un objeto del listener de botones.
        ListenerBotones listenerBotones=new ListenerBotones(this);
        //Asociamos el listener al botón de inicio de app.
        botonInicioApp.setOnClickListener(listenerBotones);
    }
}
