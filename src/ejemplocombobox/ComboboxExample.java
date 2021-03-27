/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocombobox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author JorgeLPR
 */
public class ComboboxExample extends Application {
    
    String URLCombobox="/view/ComboboxView.fxml";

    
    
    @Override
    public void init(){
        
        int option = Integer.parseInt(JOptionPane.showInputDialog("Elija una Opción \n"+
                                                        "1- Interfaz # 1 (Lección 20 y 21)\n"+
                                                        "2- Interfaz # 2 (Lección 22 y 23)\n"
                                                      + "3- ComboBox Anidados (Lección 24)"));
        
        switch (option) {
            case 1:
                URLCombobox="/view/ComboboxView.fxml";
                break;
            case 2:
                URLCombobox="/view/ComboboxViewImage.fxml";                
                break;
            default:
                URLCombobox="/view/ComboboxDependent.fxml";
                break;
        }
        
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(URLCombobox));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
