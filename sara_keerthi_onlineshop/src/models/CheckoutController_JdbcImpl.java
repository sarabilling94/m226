package models;

import database.JdbcDb;

import java.sql.*;
import java.util.ArrayList;
/**
 * JDBC implementation of CheckoutController
 */
public class CheckoutController_JdbcImpl extends  CheckoutController {
    private int IDorder;

    public CheckoutController_JdbcImpl(Cart_JdbcImpl cart) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        conn.setAutoCommit(false);

        int IDuser = cart.getIDcustomer();

        IDorder = new Order_JdbcImpl(IDuser).getIDorder();

        cart.getArrayOfCartDetails().forEach((c) ->{
            PreparedStatement checkout_stmt = null;
            try {
                checkout_stmt = conn.prepareStatement("insert into tbl_bestellungsdetails (FS_bestellung,FS_artikel,anzahl) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

                checkout_stmt.setInt(1, IDorder);
                checkout_stmt.setInt(2, c.getArticle().getIDarticle());
                checkout_stmt.setInt(3, c.getAmount());
                checkout_stmt.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public int getIDorder() {
        return IDorder;
    }

    public static ArrayList<Integer> getFSarticlesByIDorder(int IDorder){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement checkoutcontroller_stmt = conn.prepareStatement("select * from tbl_bestellungsdetails where FS_bestellung=?");
            checkoutcontroller_stmt.setInt(1, IDorder);
            checkoutcontroller_stmt.execute();
            ResultSet res = checkoutcontroller_stmt.getResultSet();
            ArrayList<Integer> list = new ArrayList<>();
            while(res.next()){
                list.add(res.getInt("FS_artikel"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Integer> getAmountByIDorder(int IDorder){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement checkoutcontroller_stmt = conn.prepareStatement("select * from tbl_bestellungsdetails where FS_bestellung=?");
            checkoutcontroller_stmt.setInt(1, IDorder);
            checkoutcontroller_stmt.execute();
            ResultSet res = checkoutcontroller_stmt.getResultSet();
            ArrayList<Integer> list = new ArrayList<>();
            while(res.next()){
                list.add(res.getInt("anzahl"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
