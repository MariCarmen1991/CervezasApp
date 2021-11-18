package com.mcarmen.cervezasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class infoAmpliada extends AppCompatActivity {
TextView nombre;
TextView tagline;
TextView abv;
TextView ibu;
TextView targetfg;
TextView targetog;
TextView ebc;
TextView srm;
TextView ph;
TextView atenuationLevel;
TextView maltaName;
TextView maltaAmount;
TextView hopsName;
TextView hopsAmount;
TextView foodPairing;
TextView brewers;
ImageView imagenCerveza;
Cerveza cervezaRecibida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_ampliada);

        cervezaRecibida = new Cerveza("");

        nombre =findViewById(R.id.et_nombre);
        tagline=findViewById(R.id.et_tagline);
        abv=findViewById(R.id.et_abv);
        ibu=findViewById(R.id.et_ibu);
        targetfg=findViewById(R.id.et_targefg);
        targetog=findViewById(R.id.et_targetog);
        ebc=findViewById(R.id.ebc);
        srm=findViewById(R.id.et_srm);
        ph=findViewById(R.id.et_ph);
        atenuationLevel=findViewById(R.id.atenuationLevel);
        maltaName=findViewById(R.id.malta_nombre);
        maltaAmount=findViewById(R.id.et_cantidad_malta);
        hopsName=findViewById(R.id.lupulo_nombre);
        hopsAmount=findViewById(R.id.et_cantidad_hops);
        foodPairing=findViewById(R.id.et_food);
        brewers=findViewById(R.id.et_brewers);
        imagenCerveza=findViewById(R.id.im_cerveza);

        recibirIntent();




    }



    public void recibirIntent(){

        cervezaRecibida= (Cerveza) getIntent().getExtras().getSerializable("infoAmpliada");
        Log.d("MARICARMEN", "--------"+cervezaRecibida.getName());

        nombre.setText(cervezaRecibida.getName());
        tagline.setText(cervezaRecibida.getTagline());
        abv.setText("abv: "+cervezaRecibida.getAbv());
        ibu.setText("ibu: "+cervezaRecibida.getIbu());
        targetfg.setText("Target fg: "+cervezaRecibida.getTarget_fg());
        targetog.setText("Target og: "+cervezaRecibida.getTarget_og());
        ebc.setText("ebc :"+cervezaRecibida.getEbc());
        srm.setText("srm: "+cervezaRecibida.getSrm());
        ph.setText("ph :"+cervezaRecibida.getPh());
        atenuationLevel.setText("Attenuation Level: "+cervezaRecibida.getAttenuation_level());
        maltaName.setText(" "+cervezaRecibida.getIngredients().getMalta().getName());
        maltaAmount.setText(" "+cervezaRecibida.getIngredients().getMalta().getAmount().getValue()+" kilograms");
        hopsName.setText(" "+cervezaRecibida.getIngredients().getHops().getName());
        hopsAmount.setText(" "+cervezaRecibida.getIngredients().getHops().getAmount().getValue()+" grams");
        foodPairing.setText(cervezaRecibida.getFood_pairing());
        brewers.setText(cervezaRecibida.getBrewers_tips());
        Picasso.get().load(cervezaRecibida.getImage_url()).into(imagenCerveza);


    }
}