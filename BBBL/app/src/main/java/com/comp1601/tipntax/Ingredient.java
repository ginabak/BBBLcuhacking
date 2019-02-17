package com.comp1601.tipntax;

import java.io.Serializable;

public class Ingredient implements Serializable{

    private String name;
    private double qty;

    public Ingredient(String name, double qty){
        this.name = name;
        this.qty = qty;
    }

    public String getName(){
        return(this.name);
    }

    public double getQty(){
        return(this.qty);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQty(double qty){
        this.qty = qty;
    }
}