package models;

import database.JdbcDb;
import utils.ImpossibleBirthdateException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Customer_JdbcImpl extends Customer {
    private final int IDuser;

    public Customer_JdbcImpl(String vorname, String nachname, String adresse, String email, String username, Date birthday, String phone, String gender, String passwort) throws SQLException, ImpossibleBirthdateException {
        Date today = java.util.Calendar.getInstance().getTime();
        if(birthday.after(today)) {
            throw new ImpossibleBirthdateException("Birthdate can't be in the future!");
        }

        Connection conn = JdbcDb.getConnection();
        conn.setAutoCommit(false);
        User_JdbcImpl user = new User_JdbcImpl(vorname, nachname, adresse, email, username, passwort);
        this.IDuser = user.getIDuser();
        PreparedStatement customer_stmt = conn.prepareStatement("insert into tbl_kunde (ID_kunde, FS_person, geschlecht, geburtsdatum, telefon) values(?,?,?,?,?)");
        customer_stmt.setInt(1, IDuser);
        customer_stmt.setInt(2, IDuser);
        customer_stmt.setString(3, gender);
        customer_stmt.setDate(4, new java.sql.Date(birthday.getTime()));
        customer_stmt.setString(5, phone);
        customer_stmt.executeUpdate();
        conn.commit();
        conn.setAutoCommit(true);
    }

    public static Customer_InMemoryImpl getCustomerById(int IDuser){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement customer_stmt = conn.prepareStatement("select * from tbl_kunde where FS_person=?");
            customer_stmt.setInt(1, IDuser);
            customer_stmt.execute();
            ResultSet res = customer_stmt.getResultSet();
            res.next();
            Date birthday = res.getDate("geburtstag");
            String gender = res.getString("geschlecht");
            String phone = res.getString("telefon");

            PreparedStatement user_stmt = conn.prepareStatement("select * from tbl_person where ID_person=?");
            user_stmt.setInt(1, IDuser);
            user_stmt.execute();
            ResultSet res2 = user_stmt.getResultSet();
            res2.next();

           Customer_InMemoryImpl customer = new Customer_InMemoryImpl(IDuser, res2.getString("vorname"), res2.getString("nachname"),
                    res2.getString("adresse"), res2.getString("email"), res2.getString("username"),res2.getString("passwort"),
                    birthday, phone, gender);
            return customer;
        } catch (SQLException | ImpossibleBirthdateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete() throws SQLException {
        Connection conn = JdbcDb.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement customer_stmt = conn.prepareStatement("delete from tbl_kunde where FS_person=?");
        customer_stmt.setInt(1, IDuser);
        customer_stmt.executeUpdate();
        User_JdbcImpl.getById(IDuser).delete();
        conn.commit();
        conn.setAutoCommit(true);
    }

    public int getIDcustomer(){
        return IDuser;
    }
}
