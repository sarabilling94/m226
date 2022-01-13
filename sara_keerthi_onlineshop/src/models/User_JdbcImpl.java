package models;

import database.JdbcDb;

import java.sql.*;

/**
 * JDBC implementation of Person
 */
public class User_JdbcImpl extends User {
    private final int UserId;

    public UserJdbc_Impl(String vorname, String nachname, String telefonnummer) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement User_stmt = conn.prepareStatement("insert into tbl_User (vorname,nachname,telefonnummer) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        User_stmt.setString(1, vorname);
        User_stmt.setString(2, nachname);
        User_stmt.setString(3, telefonnummer);
        User_stmt.executeUpdate();
        ResultSet User_res = User_stmt.getGeneratedKeys();
        User_res.next();
        UserId = User_res.getInt("id_User");
    }

    private UserJdbc_Impl(int UserId) {
        this.UserId = UserId;
    }

    public static UserJdbc_Impl getById(int UserId) {
        return new UserJdbc_Impl(UserId);
    }


    @Override
    public String getfirstName() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("select vorname from tbl_User where id_User=?");
            User_stmt.setInt(1, userId);
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

    }

    @Override
    public String getlastName() {
        return null;
    }

    @Override
    public void setlastName(String lastName) {

    }

    @Override
    public String getadress() {
        return null;
    }

    @Override
    public void setadress(String adress) {

    }


    @Override
    public void delete() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement User_stmt = conn.prepareStatement("delete from tbl_User where ID_User=?");
            User_stmt.setInt(1, UserId);
            User_stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getUserId() {
        return UserId;
    }

    //not implemented
    public boolean verifyLogin(){
        return true;
    }
}
