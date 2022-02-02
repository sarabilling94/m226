import database.BackendFactory;
import database.BackendJdbcFactory;
import models.*;
import utils.ImpossibleBirthdateException;
import utils.OutOfStockException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) throws SQLException, ParseException, OutOfStockException, ImpossibleBirthdateException {

        BackendFactory backend = new BackendJdbcFactory();

        // // create user
        // backend.createUser("testuser", "test", "test", "test", "test", "test");

        // // create article
        // backend.createArticle("testarticle2", "f", "hose", (float)12.5, "red", 5);

        // // create customer
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/01/2022");
        //backend.createCustomer("testcustomer", "test", "test", "test", "test", date, "2131232", "f", "2asdad");

        //create employee
        backend.createEmployee("totallynewemployee", "test", "test", "test",
               "test", "sdfsdfs", date, "f", "234234234", true);


        // get article from db
        Article article1 = Article_JdbcImpl.getArticleById(1);
        Article article2 = Article_JdbcImpl.getArticleById(2);
        // set instock
        Article_JdbcImpl.setinStock(50, article1.getIDarticle());
        Article_JdbcImpl.setinStock(50, article2.getIDarticle());

        // add articles from db to cart
        ArrayList<CartDetails> arrayOfCartDetails = new ArrayList<>();
        Cart_JdbcImpl cart = new Cart_JdbcImpl(arrayOfCartDetails, 1);
        cart.addItems(1, 5);
        cart.addItems(2, 3);

        cart.getArrayOfCartDetails().forEach(cartDetails ->
                System.out.println("article: " + cartDetails.getArticle().getIDarticle()
                        + "amount: " + cartDetails.getAmount())
        );

        backend.createOrder(cart);
    }
}
