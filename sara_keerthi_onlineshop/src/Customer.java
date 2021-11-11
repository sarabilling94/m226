import java.util.Date;

/** for customer registration */
public class Customer extends User {

    private Date birthday;
    private String phone;
    private String gender;

    public Customer(int IDuser, String userName, String password, String firstName,
                    String lastName, String adress, String email){
        super(IDuser, userName, password, firstName, lastName, adress, email);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
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

}
