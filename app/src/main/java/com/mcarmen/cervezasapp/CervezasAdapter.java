package com.mcarmen.cervezasapp;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CervezasAdapter extends RecyclerView.Adapter<CervezasAdapter.ViewHolder> implements View.OnClickListener{

    private ArrayList<Cerveza> listCervezas;
    private LayoutInflater mInflater;
    private Context context;
    private View.OnClickListener listener;

    public CervezasAdapter(ArrayList<Cerveza> itemCervezas, Context context) {
        this.listCervezas = itemCervezas;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;

    }


    @Override
    public CervezasAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v=mInflater.inflate(R.layout.cerveza_tarjeta, null);
        v.setOnClickListener(this);
        Log.d("MARICARMEN", "HOLAAAAAA1!");

        return new CervezasAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final CervezasAdapter.ViewHolder holder, int position) {
        holder.bindData(listCervezas.get(position));
        Picasso.get()
                .load(Uri.parse(listCervezas.get(position).getImage_url())) // internet path
                .placeholder(R.mipmap.ic_launcher)  // preload
                .error(R.mipmap.ic_launcher_round)        // load error
                .into(holder.iconImage);
        Log.d("MARICARMEN", "HOLAAAAAA2!");

    }

    @Override
    public int getItemCount() {
        return listCervezas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){

        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView nombreCerveza, malta, lupulo;



        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.imagen_cerveza);
            nombreCerveza = itemView.findViewById(R.id.caja_nombre);
            malta=itemView.findViewById(R.id.malta_etiqueta);
            lupulo=itemView.findViewById(R.id.etiqueta_lupulo);

            Log.d("MARICARMEN", "HOLAAAAAA3!");

        }

        public void bindData(final Cerveza item) {
            nombreCerveza.setText(item.getName());
            malta.setText(item.ingredients.getMalta().getName());
            lupulo.setText(item.ingredients.getHops().getName());
            Log.d("MARICARMEN", "HOLAAAAAA4!");


        }
    }



}

