package com.mcarmen.cervezasapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class BoilVolume implements Serializable {
    Double value;
    String unit;

    public BoilVolume(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static BoilVolume BoilvolumeFromJSon(JSONObject cervezaObject) throws JSONException {

        BoilVolume boilVolume= new BoilVolume(0.0,"");
        boilVolume.setValue(cervezaObject.getJSONObject("boil_volume").getDouble("value"));
        boilVolume.setUnit(cervezaObject.getJSONObject("boil_volume").getString("unit"));

        return boilVolume;

    }




}
