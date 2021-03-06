package models;

import database.JdbcDb;

import java.sql.*;

/**
 * JDBC implementation of User
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

    public User_JdbcImpl(int IDuser) {
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

    public static User_InMemoryImpl getUserById(int IDuser){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("select * from tbl_person where ID_person=?");
            User_stmt.setInt(1, IDuser);
            User_stmt.execute();
            ResultSet res = User_stmt.getResultSet();
            res.next();
            User_InMemoryImpl user = new User_InMemoryImpl(IDuser, res.getString("vorname"), res.getString("nachname"),
                    res.getString("adresse"), res.getString("email"), res.getString("username"), res.getString("passwort"));
            return user;
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
    public String getemail() {
        return null;
    }

    @Override
    public void setemail(String email) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getuserName() {
        return null;
    }

    @Override
    public void setuserName(String username) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getpassword() {
        return null;
    }

    @Override
    public void setpassword(String password) {
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

    //not implemented
    @Override
    public boolean verifyLogin(String username, String password) {
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("select * from tbl_person where username=?");
            User_stmt.setString(1, username);
            User_stmt.execute();
            ResultSet res = User_stmt.getResultSet();
            res.next();
            if (res.getString("passwort").equals(password)){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIDuser() {
        return IDuser;
    }

}