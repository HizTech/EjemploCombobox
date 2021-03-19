package model;

/**
 *
 * @author JorgeLPR
 */
public class Person {
    
    private int id;
    private String name;
    private String lastName;
    private String idType;
    private String idNumber;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    
    
    
    public Person(int id, String name, String lastName, String idType, String idNumber, String dateOfBirth, String gender, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
            
    @Override
    public String toString(){
        
        return "Id: "+getId()+"\n"+
               "Tipo Identificación: "+getIdType()+"\n"+ 
               "Número Identificación: "+getIdNumber()+"\n" +
               "Nombre Completo: "+getName() +" "+ getLastName()+"\n"+
               "Fecha De Nacimiento: "+getDateOfBirth()+"\n"+
               "Genero: "+getGender()+"\n"+
               "Telefono: "+getPhone()+"\n"+
               "Email: "+getEmail();
        
    }
    
    
    
    
}
