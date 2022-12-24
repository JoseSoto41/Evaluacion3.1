package com.example.evaluacion31;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Editar {


     class editar extends AppCompatActivity implements View.OnClickListener {
        Button btnEditActualizar, btnEditCancelar;
        TextInputLayout editUsuario, editPassword, editNombre,editApellido;
        int id=0;
        Usuario u;
        daoUsuario dao;
        Intent x;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.editar);
            editUsuario=findViewById(R.id.editUsuario);
            editPassword=findViewById(R.id.editPassword);
            editNombre=findViewById(R.id.editNombre);
            editApellido=findViewById(R.id.editApellido);
            btnEditActualizar=(Button)findViewById(R.id.btnEditActualizar);
            btnEditCancelar=(Button)findViewById(R.id.btnEditCancelar);



            Bundle b = getIntent().getExtras();
            dao= new daoUsuario(this);
            id=b.getInt("id");
            u=dao.getUsuarioById(id);

            btnEditActualizar.setOnClickListener(this);
            btnEditCancelar.setOnClickListener(this);

            editUsuario.getEditText().setText(u.getUsuario());
            editPassword.getEditText().setText(u.getPassword());

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnEditActualizar:
                    u.setUsuario(editUsuario.getEditText().getText().toString());
                    u.setPassword(editPassword.getEditText().getText().toString());
                    if (!u.isNull()){
                        Toast.makeText(this,"Error: campos vacios",Toast.LENGTH_LONG).show();
                    }else if (dao.updateUsuario(u)){
                        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(this, Inicio.class);
                        i.putExtra("id", u.getId());
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(this,"No se puede actualizar",Toast.LENGTH_LONG).show();
                    }
                case R.id.btnEditCancelar:
                    Intent c = new Intent(this, Inicio.class);
                    startActivity(c);
                    finish();
                    break;
            }
        }

    }




}
