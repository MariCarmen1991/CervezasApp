package com.mcarmen.cervezasapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Hops implements Serializable {
    String name;
    Amount amount;
    String add;
    String attribute;

    public Hops(String name, Amount amount, String add, String attribute) {
        this.name = name;
        this.amount = amount;
        this.add = add;
        this.attribute = attribute;
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }


    public static Hops hopsFromJson(JSONObject cervezaObject) throws JSONException {
        Amount amount=new Amount(0.0,"");
        Hops hops = new Hops("",amount,"","");

        JSONArray jhops=new JSONArray();
        jhops= cervezaObject.getJSONObject("ingredients").getJSONArray("hops");

        for (int i=0; i<jhops.length(); i++){

            amount.setUnit(jhops.getJSONObject(i).getJSONObject("amount").getString("unit"));
            if(jhops.getJSONObject(i).getJSONObject("amount").isNull("value")){

                amount.setValue(null);
            }
            else{
                amount.setValue(jhops.getJSONObject(i).getJSONObject("amount").getDouble("value"));

            }

            hops.setName(jhops.getJSONObject(i).getString("name"));
            hops.setAdd(jhops.getJSONObject(i).getString("add"));
            hops.setAttribute(jhops.getJSONObject(i).getString("attribute"));
            hops.setAmount(amount);
        }

        return hops;

    }




}
