package models;

import database.JdbcDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Customer_JdbcImpl extends Customer {
    private final int IDuser;

    public Customer_JdbcImpl(String vorname, String nachname, String adresse, String email, String username, Date birthday, String phone, String gender, String passwort) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        conn.setAutoCommit(false);
        User_JdbcImpl user = new User_JdbcImpl(vorname, nachname, adresse, email, username, passwort);
        this.IDuser = user.getIDuser();
        PreparedStatement customer_stmt = conn.prepareStatement("insert into tbl_kunde (FS_person, geschlecht, geburtsdatum, telefon) values(?,?,?,?)");
        customer_stmt.setInt(1, IDuser);
        customer_stmt.setString(2, gender);
        customer_stmt.setDate(3, (java.sql.Date) birthday);
        customer_stmt.setString(4, phone);
        customer_stmt.executeUpdate();
        conn.commit();
        conn.setAutoCommit(true);
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
}
