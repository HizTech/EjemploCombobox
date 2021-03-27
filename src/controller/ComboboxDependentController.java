/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.CitiesDAO;
import model.CountryDAO;
import model.entities.Cities;
import model.entities.Country;
import utilities.CitiesConverter;
import utilities.CountryConverter;

/**
 * FXML Controller class
 *
 * @author JorgeLPR
 */
public class ComboboxDependentController implements Initializable {

    @FXML
    private ComboBox<Country> cbCountries;
    
    @FXML
    private ComboBox<Cities> cbCities;
    
    private final CountryDAO modelCountries = new CountryDAO();
    private final CitiesDAO modelCities = new CitiesDAO();

    @FXML
    public void comboboxEvents(ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(cbCountries)){
            cbCities.getItems().removeAll(cbCities.getItems());
            fillComboBox(cbCities, "city", cbCountries.getSelectionModel().getSelectedItem().getId());
        }
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fillComboBox(cbCountries, "country", 0); 
        cbCountries.setConverter(new CountryConverter());
        
        cbCities.setConverter(new CitiesConverter());
        
    }    
    
    private void fillComboBox(ComboBox comboBox, String type, int param){
        ArrayList list = type.equals("country") ?  modelCountries.selectCountry(): modelCities.selectCities(param);
        if(list.size()>0){
            comboBox.getItems().addAll(list);
        }
    }
    
}
