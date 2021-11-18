package com.mcarmen.cervezasapp;

import java.io.Serializable;

public class Duration implements Serializable {
    protected Double duration;

    public Duration(Double duration) {
        this.duration = duration;
    }


    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
