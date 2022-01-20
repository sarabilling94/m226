package models;

import database.JdbcDb;

import java.sql.*;

/**
 * JDBC implementation of Person
 */
public class User_JdbcImpl extends User {
    private final int IDuser;

    public User_JdbcImpl(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement User_stmt = conn.prepareStatement("insert into tbl_person (vorname, nachname, adresse, email, username, passwort, active) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        User_stmt.setString(1, vorname);
        User_stmt.setString(2, nachname);
        User_stmt.setString(3, adresse);
        User_stmt.setString(4, email);
        User_stmt.setString(5, username);
        User_stmt.setString(6, passwort);
        User_stmt.setBoolean(7, true);
        User_stmt.executeUpdate();
        ResultSet User_res = User_stmt.getGeneratedKeys();
        User_res.next();
        IDuser = User_res.getInt("ID_person");
    }

    private User_JdbcImpl(int IDuser) {
        this.IDuser = IDuser;
    }

    public static User_JdbcImpl getById(int IDuser) {
        return new User_JdbcImpl(IDuser);
    }


    @Override
    public String getfirstName() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("select vorname from tbl_person where id_User=?");
            User_stmt.setInt(1, IDuser);
            User_stmt.execute();
            ResultSet res = User_stmt.getResultSet();
            res.next();
            return res.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setfirstName(String firstName) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getlastName() {
        return null;
    }

    @Override
    public void setlastName(String lastName) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getadress() {
        return null;
    }

    @Override
    public void setadress(String adress) {
        throw new RuntimeException("Not implemented yet");
    }


    @Override
    public void delete() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("delete from tbl_person where ID_User=?");
            User_stmt.setInt(1, IDuser);
            User_stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getIDuser() {
        return IDuser;
    }

    //not implemented
    public boolean verifyLogin(){
        return true;
    }
}