package com.isc.tesoem.agendapro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Agregar extends AppCompatActivity {

    private ArrayList<Datos> txtComplet = new ArrayList<Datos>();
    EditText txtName, txtTel, txtAddress, txtEmail;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        txtName = findViewById(R.id.txtNom);
        txtTel = findViewById(R.id.txtNum);
        txtAddress = findViewById(R.id.txtDir);
        txtEmail = findViewById(R.id.txtCor);
    }

    public void PasReg(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    public void Guard(View v){
        if(txtName.getText().toString().length() > 0  && txtTel.getText().toString().length() > 0
                && txtAddress.getText().toString().length() > 0  && txtEmail.getText().toString().length() > 0){
            FileManagement objFM = new FileManagement();
            Datos objData = new Datos(txtName.getText().toString(), txtTel.getText().toString(), txtAddress.getText().toString(), txtEmail.getText().toString());
            objFM.Reed(this);
            objFM.add(objData, objFM.getContent());
            txtComplet = objFM.getContent();
            if(objFM.Record(this, txtComplet)){
                Toast.makeText(this, "Contacto Agregado", Toast.LENGTH_SHORT).show();
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                finish();
            }else{
                Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Hay campos vacíos", Toast.LENGTH_SHORT).show();
        }
    }
}