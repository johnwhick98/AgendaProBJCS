package com.isc.tesoem.agendapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pasAg(View view){
        Intent add = new Intent(this, Agregar.class);
        startActivity(add);
        finish();
    }

    public void PasLis(View view){
        Intent list = new Intent(this, Listar.class);
        startActivity(list);
        finish();
    }

    public void PasEli(View view){
        Intent del = new Intent(this, eliminar.class);
        startActivity(del);
        finish();
    }
}
