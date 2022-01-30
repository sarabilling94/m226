package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Employee_InMemoryImpl extends Employee{
    private final User user;
    private static final ArrayList<Employee> employees  = new ArrayList<>();
    private LocalDate birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee_InMemoryImpl(int IDuser, String vorname, String nachname, String adresse, String email, String username, String passwort, LocalDate birthday, String phone, String gender, boolean admin){
        super();
        user = new User_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
        this.admin = admin;

        employees.add(this);
    }

    @Override
    public void delete(){ employees.remove(this);}
}
