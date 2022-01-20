package models;

import java.util.Date;

/** for customer registration */
public class Customer{

    private User user;
    private Date birthday;
    private String phone;
    private String gender;

    public Customer(User user, Date birthday, String phone, String gender){
        this.user = user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
