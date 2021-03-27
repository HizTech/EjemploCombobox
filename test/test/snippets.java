package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import model.CitiesDAO;
import model.CountryDAO;
import model.entities.Cities;
import model.entities.Country;

/**
 *
 * @author JorgeLPR
 */
public class snippets {
    
    public String [] arrayCitiesBolivia = {"Santa Cruz de la Sierra", "El Alto", "La Paz", "Cochabamba", "Oruro", "Sucre", "Tarija", "Potosí"}; 
    public String [] arrayCitiesChile = {"Santiago", "Concepción", "Valparaíso", "La Serena", "Temuco", "Antofagasta", "Punta Arenas", "Iquique"};
    public String [] arrayCitiesColombia = {"Bogotá", "Medellin", "Cali", "Barranquilla", "Cartagena", "Bucaramanga", "Ibagué", "Pereira"}; 
    public String [] arrayCitiesEcuador = {"Guayaquil", "Quito", "Cuenca", "Santo Domingo", "Machala", "Durán", "Manta", "Portoviejo"};        
    public String [] arrayCitiesFrancia = {"París", "Marsella", "Lyon", "Toulouse", "Niza", "Nantes", "Estrasburgo", "Montpellier"};
    public String [] arrayCitiesMexico = {"Guadalajara", "Guanajuato", "Puebla", "Morelia", "Monterrey", "Querétaro", "Merida", "Ciudad de México", "Xalapa", "Zacatecas"};
    public String [] arrayCitiesPanama = {"Panamá", "San Miguelito", "Arraiján", "Colón", "La Chorrera", "David", "Santiago de Veraguas", "Chitré"};
    public String [] arrayCitiesParaguay = {"Asunción", "Ciudad del Este", "Luque", "San Lorenzo", "Capiatá", "Lambaré", "Fernando de la Mora", "Limpio"};
    public String [] arrayCitiesPeru = {"Lima", "Arequipa", "Callao", "Trujillo", "Chiclayo", "Piura", "Huancayo", "Cusco", "Chimbote", "Iquitos"};
    public String [] arrayCitiesSpain = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Málaga", "Murcia", "Palma de Mallorca", "Las Palmas de Gran Canaria", "Bilbao"}; 
    public String [] arrayCitiesUnitedStates = {"New York", "Washington D.C.", "Miami", "San Diego", "Los Ángeles", "Chicago", "Houston"};
    public String [] arrayCitiesUruguay = {"Montevideo", "Ciudad de la Costa", "Salto", "Paysandú", "Maldonado", "Rivera", "Las Piedras", "Tacuarembo"};
    public String [] arrayCitiesArgentina = {"Buenos Aires", "Córdoba", "Rosario", "Mar del Plata", "San Miguel de Tucumán", "Salta", "Santa Fe", "Corrientes"};
    
    public CountryDAO modelCountry = new CountryDAO();
    public CitiesDAO modelCityDao = new CitiesDAO();
    private ArrayList<Country> list = new ArrayList<>();    
    
    public snippets(){        
        list = createCollectioncCountries();                
    }
    
    /*Metodos para agregar la coleccion de paises en la base de datos*/
    
    public void addCountries(){
    
        for (int i = 0; i < list.size(); i++) {
            System.out.println(modelCountry.addCountry(list.get(i)));
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

    
    /*Metodos para agregar la coleccion de ciudades de un pais en la base de datos*/
    public void addCity(Cities city){
        System.out.println(modelCityDao.addCity(city));
    }
    
    public ArrayList<Cities> createCollectionCities(int idCountry, String arrayCities []){
        
        ArrayList<Cities> cities = new ArrayList<>();
        
        for (int i = 0; i < arrayCities.length; i++) {
            cities.add(new Cities(i+1, idCountry, arrayCities[i]));            
        }
        
        return cities;
    }
    
    public void addAllCities(){

        ArrayList<Country> listCountries = modelCountry.selectCountry();
        
        if(listCountries.size()>0){
            
            for (int i = 0; i < listCountries.size(); i++) {

                ArrayList<Cities> listCities = createCollectionCities(listCountries.get(i).getId(), selectArray(listCountries.get(i).getCountry()));

                if(listCities.size()>0){
                    for (int j = 0; j < listCities.size(); j++) {
                        addCity(listCities.get(j));                    
                    }
                }            
                
            }
                                    
        }        
        
    }
    
    public String [] selectArray(String data){
        
        String array[]=null;
        
        switch(data.toLowerCase()){
        
            case "argentina":
                array = arrayCitiesArgentina;
                break;
            
            case "uruguay":
                array = arrayCitiesUruguay;
                break;
                
            case "estados unidos":
                array = arrayCitiesUnitedStates;
                break;
                
            case "españa":
                array = arrayCitiesSpain;
                break;
                
            case "perú":
                array = arrayCitiesPeru;                
                break;
                
            case "paraguay":
                array = arrayCitiesParaguay;                
                break;
                
            case "panamá":
                 array = arrayCitiesPanama;               
                break;
                
            case "méxico":
                array = arrayCitiesMexico;                
                break;
                
            case "francia":
                array = arrayCitiesFrancia;                
                break;
                
            case "ecuador":
                array = arrayCitiesEcuador;                
                break;
                
            case "colombia":
                array = arrayCitiesColombia;                
                break;
                
            case "chile":
                array = arrayCitiesChile;                
                break;
                
            case "bolivia":
                array = arrayCitiesBolivia;                
                break;
         
        }
        
        return array;
        
    }
    
    public static void main (String [] args){
        
    }
    
    
}
