package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.Country;
import utilities.GUIController;

/**
 *
 * @author JorgeLPR
 */
public class CountryDAO {
    
    public boolean addCountry(Country country){
        
        boolean state = false;
        PreparedStatement pst;
        Connection connect=null;
        
        try{
            
            connect = ConnectionDB.getInstance().getConnection();
            
            if(connect!=null){
                
                String sql = "INSERT INTO countries (country, city, flag) VALUES (?,?,?)";
                
                pst = connect.prepareStatement(sql);
                pst.setString(1, country.getCountry());
                pst.setString(2, country.getCity());
                pst.setBytes(3, country.getFlagBytes());
                int result = pst.executeUpdate();
                state = result>0;
                
            }else{
                System.err.println("Tuvimos problemas al establecer la conexión con la Base de Datos");
            }
        
        }catch(SQLException ex){
            System.err.println("Surgieron errores en el proceso de inserción: "+ex.getMessage());
        }finally{
            try{
                if(connect!=null){
                    ConnectionDB.getInstance().closeConnection(connect);
                }else{
                
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
                
        return state;
    
    }
    
    public ArrayList<Country> selectCountry(){
        
        ArrayList <Country> list = new ArrayList<>();
        Country country;
        
        PreparedStatement pst;
        ResultSet rs;
        Connection connect=null;
        
        try {
            
            connect = ConnectionDB.getInstance().getConnection();
            
            if(connect!=null){
            
                String sql = "SELECT * FROM countries WHERE 1 ORDER BY country";
                
                pst = connect.prepareStatement(sql);
                rs = pst.executeQuery();
                
                while(rs.next()){

                    country = new Country();                    
                    byte [] flagBytes = rs.getBytes("flag");                    
                    
                    country.setId(rs.getInt("id"));
                    country.setCountry(rs.getString("country"));
                    country.setCity(rs.getString("city"));
                    country.setFlagBytes(flagBytes);
                    country.setFlag(flagBytes != null ? GUIController.convertToJavaFXImage(flagBytes, 128, 76) : null);
                    
                    list.add(country);
                                        
                }
                
            }else{
                System.err.println("Tuvimos problemas al establecer la conexión con la Base de Datos");            
            }
            
        } catch (SQLException e) {
            System.err.println("Surgieron errores en el proceso de consulta: "+e.getMessage());
        }finally{
            try {
                if(connect!=null){
                    ConnectionDB.getInstance().closeConnection(connect);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        return list;
    }
    
}
