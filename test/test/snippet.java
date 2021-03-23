/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Country;

/**
 *
 * @author JorgeLPR
 */
public class snippet {
    
      /*
        comboboxCountries.getItems().addAll(createCollectioncCountries());
                
        comboboxCountries.setCellFactory(new Callback<ListView<Country>, ListCell<Country>>() {
            @Override
            public ListCell<Country> call(ListView<Country> param) {
                return new IconCell();
            }
        });
        
        comboboxCountries.setButtonCell(new IconCell());
      */  


    /*METODOS INCLUIDOS EN EL CELL FACTORY*/
    public static HBox generateHBox(Country country){        
        Label label = new Label(country.getCountry());     
        label.setFont(new Font(20));
        label.setTextFill(Color.BLACK);
        HBox hbox = new HBox(generateImageView(country.getFlag(), 64), label); 
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }    

    public static ImageView generateImageView(Image image, int width){
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(width);      
        return imageView;
    }    
    
    
    
}
