package models;

import java.util.ArrayList;
import java.util.Date;

public class Customer_InMemoryImpl extends Customer {
    private static final ArrayList<Customer> customers  = new ArrayList<>();
    private final User user;
    private Date birthday;
    private String phone;
    private String gender;

    public Customer_InMemoryImpl(int IDuser, String vorname, String nachname, String adresse, String email, String username, String passwort){
        user = new User_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort);
    }

    public Customer_InMemoryImpl(int IDuser, String vorname, String nachname, String adresse, String email, String username, String passwort, Date birthday, String phone, String gender){
        this(IDuser, vorname, nachname, adresse, email, username, passwort);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;

        customers.add(this);
    }

    @Override
    public void delete(){ customers.remove(this);}

    @Override
    public int getIDcustomer() {
        return 0;
    }
}
