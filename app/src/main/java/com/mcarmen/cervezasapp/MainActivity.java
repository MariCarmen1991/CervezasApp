package com.mcarmen.cervezasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue cola;
    JsonArrayRequest request;
    Cerveza nuevaCerveza;
    ArrayList<Cerveza> cervezas=new ArrayList<Cerveza>();
    ArrayList<Cerveza> arrayPrueba;
    ImageView img;
    CervezasAdapter cervezaAdapter;

    //ejercicio : buscardor de cerveza //buscar nombre, abv i ibu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imagen_cerveza);

        recibirJson();

    }



    public  ArrayList<Cerveza> recibirJson () {

        cola = Volley.newRequestQueue(MainActivity.this);
        String url = "https://api.punkapi.com/v2/beers ";

        request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        for (int i = 0; i < response.length(); i++) {

                            JSONObject cervezaObject=response.getJSONObject(i);

                             nuevaCerveza.cervezaFromJson(cervezaObject);
                             Log.d("MARICARMEN", "   "+nuevaCerveza.cervezaFromJson(cervezaObject).getId());

                             cervezas.add(nuevaCerveza.cervezaFromJson(cervezaObject));
                            Log.d("MARICARMEN", "   ^^^*^*^**^^*^*^*^*^*^*^*^*^*^*"+cervezas.size());
                        }
                        recyclerCerveza(cervezas);



                    } catch (JSONException e) {
                        Log.d("MARICARMEN", "msg error : " + e.getMessage() + "   " + e.getLocalizedMessage());
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
        });
        cola.add(request);
        Log.d("MARICARMEN", "---------/////----------------////------> "+cervezas.size());

        return cervezas;
    }


       public void recibirCerveza(){
            cola = Volley.newRequestQueue(MainActivity.this);
            String url = "https://api.punkapi.com/v2/beers?beer_name=";
            String params="";
            Log.d("MARICARMEN", "CERVEZAS");

            request= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d("MARICARMEN", "CERVEZAS");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            cola.add(request);}


    public void recyclerCerveza(ArrayList<Cerveza> cervezas){

        RecyclerView recyclerView = findViewById(R.id.myBeerRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        cervezaAdapter = new CervezasAdapter(cervezas, MainActivity.this);

        recyclerView.setAdapter(cervezaAdapter);
        cervezaAdapter.notifyDataSetChanged();


        cervezaAdapter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int position=recyclerView.getChildAdapterPosition(v);
                Intent iDatos = new Intent(MainActivity.this, infoAmpliada.class);
                iDatos.putExtra("infoAmpliada", cervezas.get(position));
                startActivity(iDatos);

                Log.d("MARICARMEN", "---------/////-----has hecho click-----------////------> "+cervezas.get(position));

            }
        });


    }




}
