/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

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
public class GUIController {
    
    /*METODOS INCLUIDOS EN EL HBOX*/    
    public static ImageView generateImageView(String fileName, int width){
        ImageView imageView = new ImageView(getImage(fileName));
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(width);      
        return imageView;
    }
    
    public static Image getImage(String fileName){
        return new Image(GUIController.class.getResource("/images/"+fileName+".png").toString());        
    }
    
    public static HBox generateHBox(String fileName){        
        Label label = new Label(getCountry(fileName));     
        label.setFont(new Font(20));
        HBox hbox = new HBox(generateImageView(fileName, 64), label); 
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        return hbox;
    }
    
    public static String getCountry(String fileName){
        
        String country;
        
        switch(fileName){
            
            case "argentina":
                country="Argentina";
                break;
            case "bolivia":
                country="Bolivia";
                break;
            case "chile":
                country="Chile";
                break;
            case "colombia":
                country="Colombia";
                break;
            case "ecuador":
                country="Ecuador";
                break;                
            case "francia":
                country="Francia";
                break;   
            case "mexico":
                country="México";
                break;  
            case "panama":
                country="Panamá";
                break;  
            case "paraguay":
                country="Paraguay";
                break;    
            case "peru":
                country="Perú";
                break;
            case "spain":
                country="España";
                break;                   
            case "united_states":
                country="Estados Unidos";
                break;         
            case "uruguay":
                country="Uruguay";
                break;   
            default:
                country="";
                
        }
        return country;
    }
    
    
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
