package models;

import database.JdbcDb;
import utils.ImpossibleBirthdateException;

import java.sql.*;
import java.util.Date;
/**
 * JDBC implementation of Employee
 */
public class Employee_JdbcImpl extends Employee{
    private final int IDuser;

    private Employee_JdbcImpl(int IDuser){
        this.IDuser = IDuser;
    }

    public Employee_JdbcImpl(String vorname, String nachname, String adresse, String email, String username, String passwort, java.util.Date birthday, String geschlecht, String telefon, boolean admin) throws SQLException, ImpossibleBirthdateException {
        Date today = java.util.Calendar.getInstance().getTime();
        if(birthday.after(today)) {
            throw new ImpossibleBirthdateException("Birthdate can't be in the future!");
        }

        User_JdbcImpl person = new User_JdbcImpl(vorname, nachname, adresse, email, username, passwort);
        this.IDuser = person.getIDuser();
        Connection conn = JdbcDb.getConnection();
        PreparedStatement employee_stmt = conn.prepareStatement("insert into tbl_mitarbeiter (ID_mitarbeiter, FS_person,geburtstag,geschlecht,telefon,admin) values(?,?,?,?,?,?)");
        employee_stmt.setInt(1, IDuser);
        employee_stmt.setInt(2, IDuser);
        employee_stmt.setDate(3, new java.sql.Date(birthday.getTime()));
        employee_stmt.setString(4, geschlecht);
        employee_stmt.setString(5, telefon);
        employee_stmt.setBoolean(6, admin);
        employee_stmt.executeUpdate();
    }

    public static Employee_JdbcImpl getById(int IDuser){
        return new Employee_JdbcImpl(IDuser);
    }

    public int getIDuser(){
        return IDuser;
    }

    public static Employee_InMemoryImpl getEmployeeById(int IDuser){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement employee_stmt = conn.prepareStatement("select * from tbl_mitarbeiter where FS_person=?");
            employee_stmt.setInt(1, IDuser);
            employee_stmt.execute();
            ResultSet res = employee_stmt.getResultSet();
            res.next();
            Date birthday = res.getDate("geburtstag");
            String gender = res.getString("geschlecht");
            String phone = res.getString("telefon");
            boolean admin = res.getBoolean("admin");

            PreparedStatement user_stmt = conn.prepareStatement("select * from tbl_person where ID_person=?");
            user_stmt.setInt(1, IDuser);
            user_stmt.execute();
            ResultSet res2 = user_stmt.getResultSet();
            res2.next();

            Employee_InMemoryImpl employee = new Employee_InMemoryImpl(IDuser, res2.getString("vorname"), res2.getString("nachname"),
                    res2.getString("adresse"), res2.getString("email"), res2.getString("username"),res2.getString("passwort"),
                    birthday, phone, gender, admin);
            return employee;
        } catch (SQLException | ImpossibleBirthdateException e) {
            e.printStackTrace();
            return null;
        }
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
