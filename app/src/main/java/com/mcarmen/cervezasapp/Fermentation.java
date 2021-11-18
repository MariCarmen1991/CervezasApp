package com.mcarmen.cervezasapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Fermentation implements Serializable {

   protected Temp temp;

    public Fermentation(Temp temp) {
        this.temp = temp;

    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }



    public static Fermentation fermentationFromJson(JSONObject cervezaObject) throws JSONException {
        Temp temp=new Temp(0.0,"");



        temp.setValue(cervezaObject.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").getDouble("value"));
        temp.setUnit(cervezaObject.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").getString("unit"));
        Fermentation fermentation=new Fermentation(temp);
        return fermentation;


    }






}
