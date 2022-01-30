package models;

import database.JdbcDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Order_JdbcImpl {
    private int IDorder;
    private Date date = java.util.Calendar.getInstance().getTime();

    public Order_JdbcImpl(User user) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement order_stmt = conn.prepareStatement("insert into tbl_bestellung (FS_kunde, bestelldatum) values (?,?)");
        order_stmt.setInt(1, ((User_JdbcImpl) user).getIDuser());
        order_stmt.setDate(2, (java.sql.Date) date);
        order_stmt.executeUpdate();
        ResultSet order_res = order_stmt.getGeneratedKeys();
        order_res.next();
        IDorder = order_res.getInt(1);
        conn.commit();
        conn.setAutoCommit(true);
    }

    public Order_JdbcImpl(int IDorder){
        this.IDorder = IDorder;
    }

    public static Order_JdbcImpl getById(int IDorder) {
        return new Order_JdbcImpl(IDorder);
    }

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
}
