import java.time.LocalDate;

public class Employee extends User{

    private LocalDate birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee(int IDuser, String userName, String password, String firstName, String lastName, String adress, String email, LocalDate birthday, String phone,
                    String gender, boolean admin){
        super(IDuser, userName, password, firstName, lastName, adress, email);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
        this.admin = admin;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    public LocalDate getBirthday(){
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
}
