package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.Cities;

/**
 *
 * @author JorgeLPR
 */
public class CitiesDAO {
    
    public boolean addCity(Cities city){
        
        boolean state = false;
        PreparedStatement pst;
        Connection connect=null;
        
        try{
            
            connect = ConnectionDB.getInstance().getConnection();
            
            if(connect!=null){
                
                String sql = "INSERT INTO cities (id_country, city) VALUES (?,?)";
                
                pst = connect.prepareStatement(sql);
                pst.setInt(1, city.getId());
                pst.setString(2, city.getCity());
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
    
    public ArrayList<Cities> selectCities(int idCountry){
        
        ArrayList <Cities> list = new ArrayList<>();
        Cities city;
        
        PreparedStatement pst;
        ResultSet rs;
        Connection connect=null;
        
        try {
            
            connect = ConnectionDB.getInstance().getConnection();
            
            if(connect!=null){
            
                String sql = "SELECT * FROM cities WHERE id_country=? ORDER BY city";
                
                pst = connect.prepareStatement(sql);
                pst.setInt(1, idCountry);
                rs = pst.executeQuery();
                
                while(rs.next()){

                    city = new Cities();       
                    
                    city.setCity(rs.getString("city"));
                    city.setIdCities(rs.getInt("id"));
                    city.setId(rs.getInt("id_country"));
                                        
                    list.add(city);
                                        
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
