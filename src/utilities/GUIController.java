/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.imageio.ImageIO;
import model.entities.Country;

/**
 *
 * @author JorgeLPR
 */
public class GUIController {
        
    public static Image getImage(String fileName){
        return new Image(GUIController.class.getResource("/images/"+fileName+".png").toString());        
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
    
    public static Image convertToJavaFXImage(byte[] raw, int width, int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
            System.err.println("error de conversión: "+ex.getMessage());
        }
        return image;
    }    
    
}
