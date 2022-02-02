package models;

import utils.ImpossibleBirthdateException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * In Memory implementation of Employee
 */
public class Employee_InMemoryImpl extends Employee{
    private final User user;
    private static final ArrayList<Employee> employees  = new ArrayList<>();
    private Date birthday;
    private String phone;
    private String gender;
    private boolean admin;

    public Employee_InMemoryImpl(int IDuser, String vorname, String nachname, String adresse, String email, String username, String passwort, Date birthday, String phone, String gender, boolean admin) throws ImpossibleBirthdateException {
        super();

        Date today = java.util.Calendar.getInstance().getTime();
        if(birthday.after(today)) {
            throw new ImpossibleBirthdateException("Birthdate can't be in the future!");
        }
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
