/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javafx.scene.control.ListCell;
import model.Country;

/**
 *
 * @author JorgeLPR
 */
public class IconCell extends ListCell<Country> {

    @Override
    public void updateItem(Country item, boolean empty){
        
        super.updateItem(item, empty);
 
        if (empty)
        {
            setText(null);
            setGraphic(null);
        }
        else
        {            
            setGraphic(GUIController.generateHBox(item));
        }
    }
    
}
