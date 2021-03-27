/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javafx.util.StringConverter;
import model.entities.Cities;

/**
 *
 * @author JorgeLPR
 */
public class CitiesConverter extends StringConverter<Cities> {

    @Override
    public String toString(Cities city) {
        return city == null ? null : city.getCity();
    }

    @Override
    public Cities fromString(String string) {
        return null;
    }
    
    
    
}
