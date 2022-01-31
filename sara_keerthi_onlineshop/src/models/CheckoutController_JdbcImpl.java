package models;

import database.JdbcDb;

import java.sql.*;

public class CheckoutController_JdbcImpl extends  CheckoutController {

    public CheckoutController_JdbcImpl(Cart cart) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        conn.setAutoCommit(false);

        Customer user = cart.getCustomer();
        int IDorder = new Order_JdbcImpl(user).getIDorder();

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
}
