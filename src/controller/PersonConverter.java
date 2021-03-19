package controller;

import javafx.util.StringConverter;
import model.Person;

/**
 *
 * @author JorgeLPR
 */
public class PersonConverter extends StringConverter<Person> {
    
    @Override
    public String toString(Person person) {
        return person == null ? null : person.getName() + " "+ person.getLastName();
    }

    @Override
    public Person fromString(String personString) {        
        return null;        
    }
    
}
