package models;

import database.JdbcDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order_JdbcImpl {
    private int IDorder;
    private java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    public Order_JdbcImpl(Customer customer) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement order_stmt = conn.prepareStatement("insert into tbl_bestellung (FS_kunde, bestelldatum) values (?,?), , Statement.RETURN_GENERATED_KEYS");
        order_stmt.setInt(1, ((Customer_JdbcImpl) customer).getIDcustomer());
        order_stmt.setDate(2, date);
        order_stmt.executeUpdate();
        ResultSet order_res = order_stmt.getGeneratedKeys();
        order_res.next();
        IDorder = order_res.getInt("ID_bestellung");
        conn.commit();
        conn.setAutoCommit(true);
    }

    public Order_JdbcImpl(int IDcustomer) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement order_stmt = conn.prepareStatement("insert into tbl_bestellung (FS_kunde, bestelldatum) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        order_stmt.setInt(1, IDcustomer);
        order_stmt.setDate(2, date);
        order_stmt.executeUpdate();
        ResultSet order_res = order_stmt.getGeneratedKeys();
        order_res.next();
        IDorder = order_res.getInt("ID_bestellung");
        conn.commit();
        conn.setAutoCommit(true);
    }

    // public Order_JdbcImpl(int IDorder){
    //     this.IDorder = IDorder;
    // }

    // public static Order_JdbcImpl getById(int IDorder) {
    //    return new Order_JdbcImpl(IDorder);
    //}

    int getIDorder() {
        return IDorder;
    }

    public User getCustomer() throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement order_stmt = conn.prepareStatement("select FS_kunde from tbl_bestellung where ID_bestellung=?");
        order_stmt.setInt(1, IDorder);
        order_stmt.execute();
        ResultSet res = order_stmt.getResultSet();
        res.next();
        return new User_JdbcImpl(res.getInt("FS_kunde"));
    }

    public Order_JdbcImpl getOrderByIDuser(int IDuser) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement order_stmt = conn.prepareStatement("select ID_bestellung from tbl_bestellung where FS_kunde=?");
        order_stmt.setInt(1, IDuser);
        order_stmt.execute();
        ResultSet res = order_stmt.getResultSet();
        res.next();
        return new Order_JdbcImpl(res.getInt("ID_bestellung"));
    }
}
