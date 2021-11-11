//* superclass for customer and employee class*/
public class User {
    private int IDuser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public User(int IDuser, String userName, String password, String firstName, String lastName, String adress, String email){
        this.IDuser = IDuser;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = adress;
        this.email = email;

    }


    public void setIDuser(int id){
        this.IDuser = id;
    }

    public int getIDuser(){
        return this.IDuser;
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
}
