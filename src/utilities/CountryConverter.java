/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.entities.Country;

/**
 *
 * @author JorgeLPR
 */
public class CountryConverter extends StringConverter<Country> {

    ComboBox<Country> combobox; 
    
    public CountryConverter(ComboBox<Country> combobox){
        this.combobox = combobox;
    }
     
    public CountryConverter(){
        this.combobox=null;
    }
    
    private void updateCell(){
    
        combobox.setCellFactory(new Callback<ListView<Country>, ListCell<Country>>() {
            @Override
            public ListCell<Country> call(ListView<Country> param) {
                
                ListCell cell = new ListCell<Country>(){
                
                    @Override
                    public void updateItem(Country item, boolean empty){
                        super.updateItem(item, empty);
                        if(empty){
                            setText("");
                        }else{
                            setText(item.getCountry());
                        }
                    }
                
                };

                return cell;
            }
        });
    
    }
    
    @Override
    public String toString(Country country) {
        return country == null ? null : country.getCountry();
    }

    @Override
    public Country fromString(String string) { 
        
        if(combobox != null){

            Country country = combobox.getValue();

            if(country!=null){
                country.setCountry(string);
                updateCell();                    
                return country;    
            }else{
                Country newCountry = new Country(combobox.getItems().size()+1, string, "", null);
                return newCountry;
            }
                        
        }else{
            return null;
        }
        
    }
    
}
