package com.mcarmen.cervezasapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Malta implements Serializable {
    String name;
    Amount amount;

    public Malta(String name, Amount amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    public static Malta maltaFromJson(JSONObject cervezaObject) throws JSONException {
        Amount amount=new Amount(0.0,"");
        Malta malta = new Malta("",amount);

        JSONArray jmalta=new JSONArray();
        jmalta= cervezaObject.getJSONObject("ingredients").getJSONArray("malt");

        for (int i=0; i<jmalta.length(); i++){

            amount.setUnit(jmalta.getJSONObject(i).getJSONObject("amount").getString("unit"));
            if(jmalta.getJSONObject(i).getJSONObject("amount").isNull("value")){

                amount.setValue(null);
            }
            else{
                amount.setValue(jmalta.getJSONObject(i).getJSONObject("amount").getDouble("value"));

            }

            malta.setName(jmalta.getJSONObject(i).getString("name"));
            malta.setAmount(amount);
        }

        return malta;

    }



}
