package com.mcarmen.cervezasapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MethodCerveza implements Serializable {

    protected MashTemp mashTemp;
    protected Fermentation fermentation;
    protected String twist;

    public MethodCerveza(MashTemp mashTemp, Fermentation fermentation, String twist) {
        this.mashTemp = mashTemp;
        this.fermentation = fermentation;
        this.twist = twist;
    }

    public MashTemp getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(MashTemp mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }


    public static MethodCerveza methodCervezaFromJson(JSONObject cervezaObject) throws JSONException {

        String twist=cervezaObject.getJSONObject("method").getString("twist");
        MethodCerveza methodCerveza=new MethodCerveza(MashTemp.mashTempFromJson(cervezaObject),Fermentation.fermentationFromJson(cervezaObject), twist);

        return methodCerveza;
    }

}
