import database.BackendFactory;
import database.BackendJdbcFactory;
import models.Article;
import models.Cart;
import models.CheckoutController;
import models.Customer;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) throws SQLException, ParseException {

        BackendFactory backend = new BackendJdbcFactory();

        backend.createUser("testuser", "test", "test", "test", "test", "test");

        // backend.createArticle("testarticle", "f", "hose", (float)12.5, "red", 5);

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/01/2022");
        // backend.createCustomer("testcustomer", "test", "test", "test", "test", date, "2131232",
        //        "f", "2asdad");

        // backend.createEmployee("testemploydee", "test", "test", "test",
        //        "test", "sdfsdfs", date, "f", "234234234", true);

    }
}
