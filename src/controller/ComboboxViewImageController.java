package controller;

import java.io.File;
import java.io.IOException;
import utilities.IconCell;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import model.CountryDAO;
import model.entities.Country;
import utilities.GUIController;


/**
 * FXML Controller class
 *
 * @author JorgeLPR
 */
public class ComboboxViewImageController implements Initializable {
    
    @FXML 
    private TextArea textCountry;
        
    @FXML
    private ComboBox<Country> comboboxCountries, comboboxCountriesDB;
    
    private final CountryDAO model = new CountryDAO();
    
    
    @FXML
    public void comboboxEvents(ActionEvent e){
    
        Object evt = e.getSource();
        
        if(evt.equals(comboboxCountries)){
     
            textCountry.setText(comboboxCountries.getSelectionModel().getSelectedItem().toString());
            
        }        
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        comboboxCountries.getItems().addAll(createCollectioncCountries());
        
        comboboxCountries.setCellFactory(new Callback<ListView<Country>, ListCell<Country>>() {
            @Override
            public ListCell<Country> call(ListView<Country> param) {
                return new IconCell();
            }
        });
        
        comboboxCountries.setButtonCell(new IconCell());
          
        
        ArrayList<Country> list = model.selectCountry();
        
        if(list.size()>0){
            comboboxCountriesDB.getItems().addAll(list);
            comboboxCountriesDB.setCellFactory(new Callback<ListView<Country>, ListCell<Country>>() {
                @Override
                public ListCell<Country> call(ListView<Country> param) {
                    return new IconCell();
                }
            });
            comboboxCountriesDB.setButtonCell(new IconCell());
        }
        
        
        
    }    
    

    private ArrayList<Country> createCollectioncCountries(){
        
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country(1, "Argentina", "Buenos Aires", GUIController.getImage("argentina"))); 
        countries.add(new Country(2, "Bolivia", "La Paz", GUIController.getImage("bolivia"))); 
        countries.add(new Country(3, "Chile", "Santiago", GUIController.getImage("chile"))); 
        countries.add(new Country(4, "Colombia", "Bogotá", GUIController.getImage("colombia"))); 
        countries.add(new Country(5, "Ecuador", "Quito", GUIController.getImage("ecuador"))); 
        countries.add(new Country(6, "Francia", "Paris", GUIController.getImage("francia"))); 
        countries.add(new Country(7, "México", "Ciudad de México", GUIController.getImage("mexico"))); 
        countries.add(new Country(8, "Panamá", "Ciudad de Panamá", GUIController.getImage("panama"))); 
        countries.add(new Country(9, "Paraguay", "Asunción", GUIController.getImage("paraguay"))); 
        countries.add(new Country(10, "Perú", "Lima", GUIController.getImage("peru"))); 
        countries.add(new Country(11, "España", "Madrid", GUIController.getImage("spain"))); 
        countries.add(new Country(12, "Estados Unidos", "Washington D. C.", GUIController.getImage("united_states"))); 
        countries.add(new Country(13, "Uruguay", "Montevideo", GUIController.getImage("uruguay"))); 

        return countries;
    
    }    
    

    
}
