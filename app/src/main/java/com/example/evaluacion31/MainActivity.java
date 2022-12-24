package com.example.evaluacion31;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        TextInputLayout Usuario,password;
        Button btnIngreso, btnRegistrar;
        daoUsuario dao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Usuario=findViewById(R.id.Usuario);
            password=findViewById(R.id.password);
            btnIngreso=findViewById(R.id.btnIngreso);
            btnRegistrar=findViewById(R.id.btnRegistrar);

            btnIngreso.setOnClickListener(this);
            btnRegistrar.setOnClickListener(this);
            dao= new daoUsuario(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnIngreso:
                    String u=Usuario.getEditText().getText().toString();
                    String p=password.getEditText().getText().toString();
                    if (u.equals("")&&p.equals("")){
                        Toast.makeText(this,"Error: Campos vacios",Toast.LENGTH_LONG).show();
                    }else if (dao.login(u,p)==1){
                        Usuario ux=dao.getUsuario(u,p);
                        Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
                        Intent i2=new Intent(this,Inicio.class);
                        i2.putExtra("id", ux.getId());
                        startActivity(i2);
                        finish();
                    }else{
                        Toast.makeText(this,"Usuario y/o contraseÃ±a incorrectos",Toast.LENGTH_LONG).show();
                    }
                    break;

                case R.id.btnRegistrar:
                    Intent i=new Intent(this,Registrar.class);
                    startActivity(i);
                    break;
            }

        }
    }

