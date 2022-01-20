package models;

public class User_InMemoryImpl extends User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public User_InMemoryImpl(String vorname, String nachname, String adresse, String email, String username, String passwort){
        this.userName = username;
        this.password = passwort;
        this.firstName = vorname;
        this.lastName = nachname;
        this.address = adresse;
        this.email = email;
    }

    public void setuserName(String username){ this.userName = username; }

    public String getuserName(){
        return this.userName;
    }

    public void setpassword(String password){
        this.password = password;
    }

    public String getpassword(){
        return this.password;
    }

    public void setfirstName(String firstName){
        this.firstName = firstName;
    }

    public String getfirstName(){
        return this.firstName;
    }

    public void setlastName(String lastName){
        this.lastName = lastName;
    }

    public String getlastName(){
        return this.lastName;
    }

    public void setadress(String adress){
        this.address = adress;
    }

    public String getadress(){
        return this.address;
    }

    public void setemail(String email){
        this.email = email;
    }

    public String getemail(){
        return this.email;
    }


    public boolean verifyLogin(String username, String password){
        if(this.userName == username && this.password == password){
            return true;
        }
        return false;
    }

    @Override
    public void delete() {
        throw new RuntimeException("Not implemented yet");
    }
}
