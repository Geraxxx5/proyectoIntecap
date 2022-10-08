package com.luis.intuneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.luis.intuneapp.basededatos.ProductoVO;

import java.util.ArrayList;

public class AdapterListMain extends BaseAdapter {
    private Context context;
    private int referenceList;
    ArrayList<ProductoVO> list = new ArrayList<>();

    public AdapterListMain(Context context, int reference, ArrayList<ProductoVO> list){
        this.context = context;
        this.referenceList = reference;
        this.list = list;
    }

    @Override
    public int getCount() { return this.list.size(); }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.activity_maver_productos, null);

        TextView nombre, cantidad;
        nombre = v.findViewById(R.id.txtNombreProductoVer);
        cantidad = v.findViewById(R.id.txtCantidadProductoVer);

        nombre.setText(String.valueOf(list.get(i).getDescripcionProducto()));
        cantidad.setText(String.valueOf(list.get(i).getCantidadProducto()));

        return v;
    }
}
