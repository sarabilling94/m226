package models;

import java.time.LocalDate;

public class Employee_InMemoryImpl extends Employee{
    private final User user;
    private LocalDate birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee_InMemoryImpl(String vorname, String nachname, String adresse, String email, String username, String passwort, LocalDate birthday, String phone, String gender, boolean admin){
        super();
        user = new User_InMemoryImpl(vorname, nachname, adresse, email, username, passwort);
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
        this.admin = admin;
    }

    @Override
    public void delete(){

    }

}
