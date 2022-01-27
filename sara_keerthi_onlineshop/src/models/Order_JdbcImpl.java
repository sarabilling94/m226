package models;

import database.JdbcDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Order_JdbcImpl {
    private final int IDuser;
    private ArrayList<CartDetails> arrayOfDetails;
    private Date date = java.util.Calendar.getInstance().getTime();

    public Order_JdbcImpl(ArrayList<CartDetails> arrayOfDetails, User user) throws SQLException {
        IDuser = ((User_JdbcImpl) user).getIDuser();
        Connection conn = JdbcDb.getConnection();
        PreparedStatement oder_stmt = conn.prepareStatement("insert into tbl_bestellung (FS_kunde, bestelldatum) values (?,?)");
        oder_stmt.setInt(1, IDuser);
        oder_stmt.setDate(2, (java.sql.Date) date);
        oder_stmt.executeUpdate();
    }

    private Order_JdbcImpl(int IDuser, ArrayList<CartDetails> arrayOfDetails){
        this.IDuser = IDuser;
        this.arrayOfDetails = arrayOfDetails;
    }
}
