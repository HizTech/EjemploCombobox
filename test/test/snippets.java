package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import model.CountryDAO;
import model.entities.Country;
import utilities.GUIController;

/**
 *
 * @author JorgeLPR
 */
public class snippets {
    
    private final CountryDAO model = new CountryDAO();
        
    public snippets(){
        
        ArrayList<Country> list = createCollectioncCountries();
        
        model.addCountry(list.get(0));
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(model.addCountry(list.get(i)));
        }        
        
    }
    
    private ArrayList<Country> createCollectioncCountries(){
        
        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country(1, "Argentina", "Buenos Aires", null, toBytes("src/images/argentina.png"))); 
        countries.add(new Country(2, "Bolivia", "La Paz", null, toBytes("src/images/bolivia.png"))); 
        countries.add(new Country(3, "Chile", "Santiago", null, toBytes("src/images/chile.png") )); 
        countries.add(new Country(4, "Colombia", "Bogotá", null, toBytes("src/images/colombia.png"))); 
        countries.add(new Country(5, "Ecuador", "Quito", null, toBytes("src/images/ecuador.png"))); 
        countries.add(new Country(6, "Francia", "Paris", null, toBytes("src/images/francia.png"))); 
        countries.add(new Country(7, "México", "Ciudad de México", null, toBytes("src/images/mexico.png"))); 
        countries.add(new Country(8, "Panamá", "Ciudad de Panamá", null, toBytes("src/images/panama.png"))); 
        countries.add(new Country(9, "Paraguay", "Asunción", null, toBytes("src/images/paraguay.png"))); 
        countries.add(new Country(10, "Perú", "Lima", null, toBytes("src/images/peru.png"))); 
        countries.add(new Country(11, "España", "Madrid", null, toBytes("src/images/spain.png"))); 
        countries.add(new Country(12, "Estados Unidos", "Washington D. C.", null, toBytes("src/images/united_states.png"))); 
        countries.add(new Country(13, "Uruguay", "Montevideo", null, toBytes("src/images/uruguay.png"))); 

        return countries;
    
    }    
    
    private File loadFile (String url){
        return new File(url);
    }
    
    private byte [] toBytes(String url){
        File file = loadFile(url);
        byte [] imageBytes = null;
        if(file!=null){
            try {
                imageBytes = Files.readAllBytes(file.toPath());
            } catch (IOException ex) {
                System.err.println("error de conversión; "+ex.getMessage());
            }
        }
        return imageBytes;
    }    
    
    public static void main (String [] args){
        //snippets snippets = new snippets();
    }
    
    
}
