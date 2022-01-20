package models;

//* superclass for customer and employee class*/
abstract public class User {
    private int IDuser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;


    //public abstract void setIDuser(int id);

    //public abstract int getIDuser();

    public abstract void setuserName(String username);

    public abstract String getuserName();

    public abstract void setpassword(String password);

    public abstract String getpassword();

    public abstract void setfirstName(String firstName);

    public abstract String getfirstName();

    public abstract void setlastName(String lastName);

    public abstract String getlastName();

    public abstract void setadress(String adress);

    public abstract String getadress();

    public abstract void setemail(String email);

    public abstract String getemail();

    public abstract void delete();

    public abstract boolean verifyLogin(String username, String password);
}
