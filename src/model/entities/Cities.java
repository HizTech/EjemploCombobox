/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author JorgeLPR
 */
public class Cities extends Country{
        
    private int idCities;
    private String city;
    
    public Cities(){}
    
    public Cities(int idCities, int idCountry, String city) {
        super(idCountry, "", "", null);
        this.idCities = idCities;
        this.city = city;
    }
        
    public int getIdCities() {
        return idCities;
    }

    public void setIdCities(int idCities) {
        this.idCities = idCities;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString(){
        return idCities+" "+ getId()+ " "+city;
    }
    
    
}
