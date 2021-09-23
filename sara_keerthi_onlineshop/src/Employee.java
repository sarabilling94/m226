import java.util.Date;

public class Employee extends User{


    private Date birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee(int IDuser, String userName, String password, String firstName, String lastName, String adress, String email){
        super(IDuser, userName, password, firstName, lastName, adress, email);
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public Date getBirthday(){
        return this.birthday;
    }

    public void setphone(String phone){
        this.phone = phone;
    }

    public String getphone(){
        return this.phone;
    }


    public void setgender(String gender){
        this.gender = gender;
    }

    public String getgender(){
        return this.gender;
    }

    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    public boolean getAdmin(){
        return this.admin;
    }

    public void register(Date birthday, String phone, String gender, boolean admin){
        setBirthday(birthday);
        setphone(phone);
        setgender(gender);
        setAdmin(admin);
    }
}
