package models;

import java.time.LocalDate;

/** for employee registration */
public class Employee{

    private User user;
    private LocalDate birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee(User user, LocalDate birthday, String phone, String gender, boolean admin){
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
