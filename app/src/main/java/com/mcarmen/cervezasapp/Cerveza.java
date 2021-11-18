package com.mcarmen.cervezasapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Cerveza implements Serializable {

    protected String id;
    protected String name;
    protected String tagline;
    protected String first_brewed;
    protected String description;
    protected String image_url;
    protected Double abv;
    protected Double ibu;
    protected Double target_fg;
    protected Double target_og;
    protected Double ebc;
    protected Double srm;
    protected String  ph;
    protected Double attenuation_level;
    protected Volume volume;
    protected BoilVolume boil_Volum;
    protected Ingredients ingredients;
    protected MethodCerveza method_cerveza;
    protected String food_pairing;
    protected String brewers_tips;
    protected String contributed_by;


    public Cerveza(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(Double target_fg) {
        this.target_fg = target_fg;
    }

    public Double getTarget_og() {
        return target_og;
    }

    public void setTarget_og(Double target_og) {
        this.target_og = target_og;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        this.ebc = ebc;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Double getAttenuation_level() {
        return attenuation_level;
    }

    public void setAttenuation_level(Double attenuation_level) {
        this.attenuation_level = attenuation_level;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoil_Volum() {
        return boil_Volum;
    }

    public void setBoil_Volum(BoilVolume boil_Volum) {
        this.boil_Volum = boil_Volum;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public MethodCerveza getMethod_cerveza() {
        return method_cerveza;
    }

    public void setMethod_cerveza(MethodCerveza method_cerveza) {
        this.method_cerveza = method_cerveza;
    }

    public String getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(String food_pairing) {
        this.food_pairing = food_pairing;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }

    public static Cerveza cervezaFromJson(JSONObject cervezaObject) throws JSONException {
        Cerveza nuevaCerveza= new Cerveza("");

        nuevaCerveza.setName(cervezaObject.getString("name"));
        nuevaCerveza.setId(cervezaObject.getString("id"));
        nuevaCerveza.setTagline(cervezaObject.getString("tagline"));
        nuevaCerveza.setFirst_brewed(cervezaObject.getString("first_brewed"));
        nuevaCerveza.setDescription(cervezaObject.getString("description"));
        nuevaCerveza.setTarget_fg(cervezaObject.getDouble("target_fg"));
        nuevaCerveza.setTarget_og(cervezaObject.getDouble("target_og"));

        if(cervezaObject.isNull("ibu")){
            nuevaCerveza.setIbu(null);
        }
        else {
            nuevaCerveza.setIbu((Double)cervezaObject.getDouble("ibu"));
        }

        nuevaCerveza.setImage_url(cervezaObject.getString("image_url"));

        nuevaCerveza.setFood_pairing(cervezaObject.getString("food_pairing"));
        nuevaCerveza.setBrewers_tips(cervezaObject.getString("brewers_tips"));
        nuevaCerveza.setContributed_by(cervezaObject.getString("contributed_by"));

        double abv = cervezaObject.getDouble("abv");
        nuevaCerveza.setAbv(0.0);
        //ABV
        if(cervezaObject.isNull("abv")) {
            nuevaCerveza.setAbv(null);
        }
        else{
            nuevaCerveza.setAbv((Double)cervezaObject.getDouble("abv"));
        }
        nuevaCerveza.setEbc(0.0);
        //EBC
        if(cervezaObject.isNull("ebc")) {
            nuevaCerveza.setEbc(null);
        }
        else{
             nuevaCerveza.setEbc((Double)cervezaObject.getDouble("ebc"));
        }

        //SRM
        if(cervezaObject.isNull("srm")) {
            nuevaCerveza.setSrm(null);
        }
        else{
            nuevaCerveza.setSrm((Double)cervezaObject.getDouble("ebc"));
        }

        //PH
        nuevaCerveza.setPh(cervezaObject.getString("ph"));

        if(cervezaObject.isNull("attenuation_level")){
            nuevaCerveza.setAttenuation_level(null);
        }
        else {
            nuevaCerveza.setAttenuation_level((Double)cervezaObject.getDouble("attenuation_level"));
        }

        nuevaCerveza.setIngredients(Ingredients.ingredientsFromJson(cervezaObject));
        nuevaCerveza.setBoil_Volum(BoilVolume.BoilvolumeFromJSon(cervezaObject));
        nuevaCerveza.setVolume(Volume.volumeFromJSon(cervezaObject));
        nuevaCerveza.setMethod_cerveza(MethodCerveza.methodCervezaFromJson(cervezaObject));

        return nuevaCerveza;
    }


}
