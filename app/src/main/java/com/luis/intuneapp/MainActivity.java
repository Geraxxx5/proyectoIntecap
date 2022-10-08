package com.luis.intuneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.luis.intuneapp.basededatos.ProductoDAO;
import com.luis.intuneapp.basededatos.ProductoVO;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    private Button buttonVerProductos, buttonComprar;
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO pvo = new ProductoVO();
    ListView listViewMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMain = findViewById(R.id.listProductos);
        pdao.listarMostrarSW(pvo, getApplicationContext(),this, this);

    }

    private void abrirVerProductos(){
        Intent intent =new Intent(getApplicationContext(), MAVerProductos.class);
        startActivity(intent);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        System.err.println(error);
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<ProductoVO> list = new ArrayList<>();
        if(pdao.respuestaListarMostrar(response) != null){
            for(ProductoVO prod: pdao.respuestaListarMostrar(response)){
                if(prod.getEstadoProducto() == 0){
                    list.add(new ProductoVO(prod.getIdProducto(), prod.getDescripcionProducto(), prod.getCantidadProducto(), prod.getPrecioProducto(), prod.getEstadoProducto()));
                }
            }
            AdapterListMain adapterListMain = new AdapterListMain(this, R.layout.recyclerview_item, list);
            listViewMain.setAdapter(adapterListMain);

            
        }
    }
}