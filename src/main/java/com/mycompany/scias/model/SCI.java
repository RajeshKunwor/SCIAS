/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scias.model;

/**
 *
 * @author rajes
 */
//this is SCI class 
public class SCI {
    private int id;
    private SoftwareComponent component;
    private float e;//Energy consumed by software in kWh
    private float i;//Carbon emitted per kWh of energy, gCO2/kWh
    private float m;//Carbon emitted through the hardware that the software is running on
    private String r;//Functional Unit; this is how the software scales, for example per user or per device
    private String result;
    
    //default constructor
    public SCI(){
        
    }
    
    //parameterized constructor
    public SCI(float e, float i, float m, String r, SoftwareComponent component){
        this.e = e;
        this.i = i;
        this.m  = m;
        this.r = r;
        this.component = component;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the component
     */
    public SoftwareComponent getComponent() {
        return component;
    }

    /**
     * @param component the component to set
     */
    public void setComponent(SoftwareComponent component) {
        this.component = component;
    }

    /**
     * @return the e
     */
    public float getE() {
        return e;
    }

    /**
     * @param e the e to set
     */
    public void setE(float e) {
        this.e = e;
    }

    /**
     * @return the i
     */
    public float getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(float i) {
        this.i = i;
    }

    /**
     * @return the m
     */
    public float getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(float m) {
        this.m = m;
    }

    /**
     * @return the r
     */
    public String getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(String r) {
        this.r = r;
    }
    
    
    //calcualte sci
    public String calculateSCI(){
        float total;
        total = ((this.e*this.i)+this.m);
        this.setResult("Total SCI of the given software componet is "+total +" "+ this.r);
        return this.getResult();
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }
    
    public String toString(){
        return "" + this.result;
    }
}
