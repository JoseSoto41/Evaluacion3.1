package com.example.evaluacion31;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio {

    public class inicio extends AppCompatActivity implements View.OnClickListener {
        Button mostrar, salir, editar, eliminar;
        int id=0;
        Usuario u;
        daoUsuario dao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inicio);
            mostrar=findViewById(R.id.btnMostrar);
            salir=findViewById(R.id.btnSalir);
            editar=findViewById(R.id.btnEditar);
            eliminar=findViewById(R.id.btnEliminar);
            mostrar.setOnClickListener(this);
            salir.setOnClickListener(this);
            editar.setOnClickListener(this);
            eliminar.setOnClickListener(this);

            Bundle b=getIntent().getExtras();
            dao= new daoUsuario(this);
            id=b.getInt("id");
            u=dao.getUsuarioById(id);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnMostrar:
                    Intent i=new Intent(this,Mostrar.class);
                    startActivity(i);
                    break;
                case R.id.btnSalir:
                    Intent c=new Intent(this,MainActivity.class);
                    startActivity(c);
                    finish();
                    break;
                case R.id.btnEditar:
                    Intent a=new Intent(this,Editar.class);
                    a.putExtra("id", id);
                    startActivity(a);
                case R.id.btnEliminar:
                    break;
            }

        }
    }


}
