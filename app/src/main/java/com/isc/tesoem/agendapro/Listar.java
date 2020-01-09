package com.isc.tesoem.agendapro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;

public class Listar extends AppCompatActivity {

    private ArrayList<Datos> txtComplet = new ArrayList<Datos>();
    GridView gvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        gvList = findViewById(R.id.gvList);
        viewContent();
    }

    public void pasReg(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }

    public void viewContent() {
        FileManagement objFM = new FileManagement();
        objFM.Reed(this);
        txtComplet = objFM.getContent();
        String[] data = objFM.fillGV(txtComplet);
        if (!(data.length == 4)) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
            gvList.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Agenda vacía", Toast.LENGTH_SHORT).show();
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }
    }
}