package com.udacity.vehicles.domain.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarListWrapper {

    @JsonProperty("_embedded")
    private EmbeddedCarList embeddedCarList;

    public EmbeddedCarList getEmbeddedCarList() {
        return embeddedCarList;
    }

    public void setEmbeddedCarList(EmbeddedCarList embeddedCarList) {
        this.embeddedCarList = embeddedCarList;
    }
}