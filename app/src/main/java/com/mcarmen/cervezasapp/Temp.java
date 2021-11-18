package com.mcarmen.cervezasapp;

import java.io.Serializable;

public class Temp implements Serializable {

    double value;
    String unit;

    public Temp(double value, String unit) {
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
}
