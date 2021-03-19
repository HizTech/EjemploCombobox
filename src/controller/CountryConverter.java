/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.Country;

/**
 *
 * @author JorgeLPR
 */
public class CountryConverter extends StringConverter<Country> {

    ComboBox<Country> combobox;
    
    public CountryConverter(ComboBox<Country> combobox){
        this.combobox = combobox;
    }
    
    @Override
    public String toString(Country country) {
        return country == null ? null : country.getCountry();
    }

    @Override
    public Country fromString(String string) {

        Country person = combobox.getValue();        
        
        if (person == null) {            
            Country newPerson = new Country();
            newPerson.setCountry(string);
            
            return newPerson;
        } else {
            
            person.setCountry(string);
            
combobox.setCellFactory(
    new Callback<ListView<Country>, ListCell<Country>>() {
        @Override
        public ListCell<Country> call(ListView<Country> p) {
            ListCell cell = new ListCell<Object>() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText("");
                    } else {
                        setText(getStringField(item));
                    }
                }
                
                public String getStringField(Object item){
                    return ((Country) item).getCountry();
                }
            };return cell;
        }
    });  
            
            return person ;
        }
        
        
        
        
    }
    
}
