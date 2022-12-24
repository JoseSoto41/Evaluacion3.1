package com.example.evaluacion31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener{
    EditText us, pas, nom,ap;
    Button reg,can;
    daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        us = (EditText) findViewById(R.id.regUsuario);
        pas = (EditText) findViewById(R.id.regPassword);
        nom = (EditText) findViewById(R.id.regNombre);
        ap = (EditText) findViewById(R.id.regApellido);
        reg = (Button) findViewById(R.id.btnRegRegistrar);
        can = (Button) findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegRegistrar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setUsuario(pas.getText().toString());
                u.setUsuario(nom.getText().toString());
                u.setUsuario(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR: Campos vacios",Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                }



                break;
            case R.id.btnRegCancelar:
                Intent i = new Intent(Registrar.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
