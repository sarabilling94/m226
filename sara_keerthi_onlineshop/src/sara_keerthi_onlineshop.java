import database.BackendFactory;
import database.BackendJdbcFactory;
import models.Article;
import models.Cart;
import models.CheckoutController;
import models.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) throws SQLException {

        BackendFactory backend = new BackendJdbcFactory();

        backend.createUser("testuser", "test", "test", "test", "test", "test");

    }
}
