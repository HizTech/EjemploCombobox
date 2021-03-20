package model;

/**
 *
 * @author JorgeLPR
 */
public class Country {
    
    private int id;
    private String country;
    private String city;

    public Country(int id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    /*
    @Override
    public String toString() {
        return  "id: "+id+ 
                "country: "+country+
                "city:" + city;
    }*/

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", country=" + country + ", city=" + city + '}';
    }
    
    
    
}
