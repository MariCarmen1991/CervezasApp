package com.mcarmen.cervezasapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Ingredients implements Serializable {
  protected Malta malta;
  protected  Hops hops;
  protected String yeast;

    public Ingredients(Malta malta, Hops hops, String yeast) {
        this.malta = malta;
        this.hops = hops;
        this.yeast = yeast;
    }

    public Malta getMalta() {
        return malta;
    }

    public void setMalta(Malta malta) {
        this.malta = malta;
    }

    public Hops getHops() {
        return hops;
    }

    public void setHops(Hops hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }



    public static Ingredients ingredientsFromJson(JSONObject cervezaObject) throws JSONException {

        String yeast="";
        yeast=cervezaObject.getJSONObject("ingredients").getString("yeast");
        Ingredients ingredients=new Ingredients(Malta.maltaFromJson(cervezaObject), Hops.hopsFromJson(cervezaObject),yeast);



        return ingredients;

    }
}
