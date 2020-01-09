package com.isc.tesoem.agendapro;

import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileManagement {

    private ArrayList<Datos> TextCompletData = new ArrayList<Datos>();
    private final String nomArch = "Datbjcs.txt";

    public boolean Record(Context context, ArrayList<Datos> dato){
        try{
            Gson gson = new Gson();
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(nomArch, Activity.MODE_PRIVATE));
            for(Datos e: dato){
                Datos data = new Datos(e.getName(), e.getTel(), e.getAddress(), e.getEmail());
                String cjson = gson.toJson(data);
                archivo.write(cjson + "\n");
            }
            archivo.flush();
            archivo.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean Reed(Context context){
        try{
            Gson gson = new Gson();
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(nomArch));
            BufferedReader br = new BufferedReader(archivo);
            String cadena = br.readLine();
            while(cadena != null){
                Datos objDa = gson.fromJson(cadena, Datos.class);
                Datos obj = new Datos();
                obj.setName(objDa.getName());
                obj.setTel(objDa.getTel());
                obj.setAddress(objDa.getAddress());
                obj.setEmail(objDa.getEmail());
                TextCompletData.add(obj);
                cadena = br.readLine();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Datos> getContent(){
        return TextCompletData;
    }

    public void add(Datos dato, ArrayList<Datos> textComplet){
        this.TextCompletData = textComplet;
        this.TextCompletData.add(dato);
    }

    public boolean DeleteRow(Context context, String[] cadena, ArrayList<Datos> data){
        ArrayList<Datos> temp = new ArrayList<Datos>();
        for(Datos e: data){
            if(!(e.getName().equals(cadena[0]) && e.getTel().equals(cadena[1]))){
                Datos obj = new Datos(e.getName(), e.getTel(), e.getAddress(), e.getEmail());
                temp.add(obj);
            }
        }
        TextCompletData = temp;
        return true;
    }

    public String[] fillGV(ArrayList<Datos> txtComplet){
        String[] data = new String[(txtComplet.size() * 4) + 4];
        int col = 4;

        data[0] = "Nombre";
        data[1] = "Telefono";
        data[2] = "Direccion";
        data[3] = "Correo";

        for(Datos e: txtComplet){
            data[col] = e.getName();
            data[col + 1] = e.getTel();
            data[col + 2] = e.getAddress();
            data[col + 3] = e.getEmail();
            col += 4;
        }
        return data;
    }

    public String[] retNameTel(ArrayList<Datos> txtComplet){
        String[] data = new String[txtComplet.size()];
        int i = 0;
        for(Datos e: txtComplet){
            data[i] = e.getName() + " | " + e.getTel();
            i++;
        }
        return data;
    }
}
