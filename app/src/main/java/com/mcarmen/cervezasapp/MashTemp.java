package com.mcarmen.cervezasapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class MashTemp implements Serializable {

    Temp temp;
    Duration duration;

    public MashTemp(Temp temp, Duration duration) {
        this.temp = temp;
        this.duration = duration;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public static MashTemp mashTempFromJson(JSONObject cervezaObject) throws JSONException {

        JSONArray arrayMash=new JSONArray();
        arrayMash= cervezaObject.getJSONObject("method").getJSONArray("mash_temp");
        //Log.d("MARICARMEN","xxxxxx "+cervezaObject.getJSONObject("method").getDouble("duration"));


        Temp temp =new Temp(0.0,"");
        Duration duration=new Duration(null);

        for (int i=0; i<arrayMash.length(); i++){

            temp.setValue(arrayMash.getJSONObject(i).getJSONObject("temp").getDouble("value"));
            temp.setUnit(arrayMash.getJSONObject(i).getJSONObject("temp").getString("unit"));


            if(arrayMash.getJSONObject(i).isNull("duration")){
            Log.d("MARICARMEN","Error nulo "+arrayMash);
                duration.setDuration(null);

            }
            else{
                Log.d("MARICARMEN","ARRAYMASH "+arrayMash);
                duration.setDuration((Double)arrayMash.getJSONObject(i).getDouble("duration"));
            }


        }
        MashTemp mashTemp= new MashTemp(temp,duration);
        return mashTemp;

    }



}
