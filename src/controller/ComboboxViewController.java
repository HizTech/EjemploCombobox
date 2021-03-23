/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Country;
import model.Person;
import utilities.CountryConverter;
import utilities.PersonConverter;

/**
 *
 * @author JorgeLPR
 */
public class ComboboxViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboboxPerson;
    
    @FXML
    private ComboBox<Country> comboboxCountries;
    
    @FXML 
    private TextField textSearch;
    
    @FXML
    private Button btnSearch, btnPull;
    
    @FXML
    private TextArea textPerson, textCountry;
    
    @FXML
    public void comboboxEvents(ActionEvent e){
    
        Object evt = e.getSource();
        
        if(evt.equals(comboboxPerson)){
            
            textPerson.setText(comboboxPerson.getSelectionModel().getSelectedItem().toString());
        
        }else if(evt.equals(comboboxCountries)){
        
            textCountry.setText(comboboxCountries.getSelectionModel().getSelectedItem().toString());
            
        }else if(evt.equals(btnSearch)){
        
            String id = textSearch.getText();
            
            try{
                
                int idSearch = Integer.parseInt(id);
                int index = getIndexSelected(idSearch, comboboxPerson);
                
                if(index != -1){
                    comboboxPerson.getSelectionModel().select(index);
                }else{
                    JOptionPane.showMessageDialog(null, "Valor inexistente; intente nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            
            }catch(HeadlessException | NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Error de formato; ingrese un valor numerico ", "ERROR", JOptionPane.ERROR_MESSAGE);                
            }
                        
        }else if(evt.equals(btnPull)){
            JOptionPane.showMessageDialog(null, showList());
        }
    
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                                
        comboboxPerson.getItems().addAll(createCollectionPersons());        
        comboboxPerson.setConverter(new PersonConverter());                       
        comboboxPerson.getSelectionModel().select(0);
        
        comboboxCountries.getItems().addAll(createCollectioncCountries());        
        comboboxCountries.setConverter(new CountryConverter(comboboxCountries));  
        
          
        
        
    }    
    
    private ArrayList<Person> createCollectionPersons(){
        
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person(1, "José", "Perez", "Cedula de Ciudadania", "10457772323", "1994-05-09", "Masculino", "jose@gmail.com", "9876765"));
        persons.add(new Person(2, "Juan", "Lopez", "Cedula de Ciudadania", "8740823", "1995-03-01", "Masculino", "juan@gmail.com", "3766765"));
        persons.add(new Person(3, "Jorge", "Martinez", "Cedula de Ciudadania", "7345345", "1996-04-19", "Masculino", "jorge@gmail.com", "4756787"));
        persons.add(new Person(4, "Miguel", "Rodriguez", "Cedula de Ciudadania", "4678987", "1997-07-20", "Masculino", "miguel@gmail.com", "5467676"));
        persons.add(new Person(5, "Andrea", "Suarez", "Cedula de Ciudadania", "1234765", "1998-08-21", "Femenino", "andrea@gmail.com", "8767676"));
        persons.add(new Person(6, "Maria", "Hernandez", "Cedula de Ciudadania", "3456765", "1999-09-30", "Femenino", "maria@gmail.com", "3829898"));
        persons.add(new Person(7, "Sofia", "Aponte", "Cedula de Ciudadania", "2345098", "2000-01-20", "Femenino", "sofia@gmail.com", "4346575"));
        persons.add(new Person(8, "Leticia", "Smith", "Cedula de Ciudadania", "3678654", "1950-12-12", "Femenino", "leticia@gmail.com", "5558798"));
        persons.add(new Person(9, "Amanda", "Salas", "Cedula de Ciudadania", "4654234", "1960-11-11", "Femenino", "amanda@gmail.com", "6669809"));
        persons.add(new Person(10, "Martina", "Salazar", "Cedula de Ciudadania", "2345654", "1970-04-09", "Femenino", "martina@gmail.com", "7893434"));
        
        return persons;
    
    }

    private ArrayList<Country> createCollectioncCountries(){
        
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country(1, "Brasil", "Brasilia", null));        
        countries.add(new Country(2, "Argentina", "Buenos Aires", null));        
        countries.add(new Country(3, "Colombia", "Bogota", null));
        countries.add(new Country(4, "Perú", "Lima", null));
        countries.add(new Country(5, "Chile", "Santiago", null));
        countries.add(new Country(6, "Venezuela", "Caracas", null));
        countries.add(new Country(7, "Ecuador", "Quito", null));        
        countries.add(new Country(8, "Bolivia", "La Paz", null));        
        countries.add(new Country(9, "Uruguay", "Montevideo", null));        
        countries.add(new Country(10, "Paraguay", "Asunción", null));        
                
        return countries;
    
    }

    
    private int getIndexSelected(int id, ComboBox<Person> comboBox){
        
        ObservableList<Person> list = comboBox.getItems();
        boolean state = true;
        int i=0, index=-1;
        
        while(state && i<list.size()){
            if(list.get(i).getId() == id){
                state=false;
                index=i;
            }else{
                i++;            
            }
        }
        
        return index;
    }

    private String showList() {
        ObservableList<Country> list = comboboxCountries.getItems();
        String show="";
        for (int i = 0; i < list.size(); i++) {
            show = show + list.get(i) + "\n";
        }
        return show;
    }
    
    
}
