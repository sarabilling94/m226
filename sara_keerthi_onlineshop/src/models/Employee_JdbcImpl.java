package models;

import database.JdbcDb;

import java.sql.*;
import java.time.LocalDate;

public class Employee_JdbcImpl extends Employee{
    private final int IDuser;

    private Employee_JdbcImpl(int IDuser){
        this.IDuser = IDuser;
    }

    public Employee_JdbcImpl(String vorname, String nachname, String adresse, String email, String username, String passwort, LocalDate geburtstag, String geschlecht, String telefon, boolean admin) throws SQLException {
        User_JdbcImpl person = new User_JdbcImpl(vorname, nachname, adresse, email, username, passwort);
        this.IDuser = person.getIDuser();
        Connection conn = JdbcDb.getConnection();
        PreparedStatement employee_stmt = conn.prepareStatement("insert into tbl_mitarbeiter (FS_person,geburtstag,geschlecht,telefon,admin) values(?,?,?,?,?)");
        employee_stmt.setInt(1, IDuser);
        employee_stmt.setDate(2, Date.valueOf(geburtstag));
        employee_stmt.setString(4, telefon);
        employee_stmt.setBoolean(5, admin);
        employee_stmt.executeUpdate();
    }

    public static Employee_JdbcImpl getById(int IDuser){
        return new Employee_JdbcImpl(IDuser);
    }

    public int getIDuser(){
        return IDuser;
    }

    @Override
    public void delete() throws SQLException{
        Connection conn = JdbcDb.getConnection();
        PreparedStatement employee_stmt = conn.prepareStatement("delete from tbl_mitarbeiter where FS_person=?");
        employee_stmt.setInt(1, IDuser);
        employee_stmt.executeUpdate();
        User_JdbcImpl.getById(IDuser).delete();
    }
}
