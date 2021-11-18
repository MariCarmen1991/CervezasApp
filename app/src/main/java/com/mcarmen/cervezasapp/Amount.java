package com.mcarmen.cervezasapp;

import java.io.Serializable;

public class Amount implements Serializable {

    Double value;
    String unit;

    public Amount(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
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
}
