package models;

import java.util.ArrayList;
import java.util.Date;

public class Customer_InMemoryImpl extends Customer {
    private static final ArrayList<Customer> customers  = new ArrayList<>();
    private User user;
    private Date birthday;
    private String phone;
    private String gender;

    public Customer_InMemoryImpl(String vorname, String nachname, String adresse, String email, String username, String passwort){
        user = new User_InMemoryImpl(vorname, nachname, adresse, email, username, passwort);
    }

    public Customer_InMemoryImpl(String vorname, String nachname, String adresse, String email, String username, String passwort, Date birthday, String phone, String gender){
        this(vorname, nachname, adresse, email, username, passwort);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public void delete(){ customers.remove(this);}
}
