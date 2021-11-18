package com.mcarmen.cervezasapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Volume implements Serializable {
    double value;
    String unit;

    public Volume(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static Volume volumeFromJSon(JSONObject cervezaObject) throws JSONException {

        Volume volume= new Volume(0,"");
        volume.setValue(cervezaObject.getJSONObject("volume").getDouble("value"));
        volume.setUnit(cervezaObject.getJSONObject("volume").getString("unit"));

        return volume;

    }


}
