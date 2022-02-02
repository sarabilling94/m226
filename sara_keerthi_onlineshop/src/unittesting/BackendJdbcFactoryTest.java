package unittesting;

import database.BackendFactory;
import database.BackendJdbcFactory;
import models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.ImpossibleBirthdateException;
import utils.OutOfStockException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BackendJdbcFactoryTest {

    BackendFactory backend;

    @BeforeEach
    void setup(){
        backend = new BackendJdbcFactory();
    }

    @org.junit.jupiter.api.Test
    void putUserTest() throws SQLException {
        // act
        User user = backend.createUser("Usertest", "Usertest", "Usertest",
                "Usertest", "Usertest", "Usertest");

        User expectedUser = new User_InMemoryImpl(user.getIDuser(), "Usertest", "Usertest",
                "Usertest", "Usertest", "Usertest", "Usertest");

        User actualUser = User_JdbcImpl.getUserById(user.getIDuser());

        // assert
        assertEquals(expectedUser.getfirstName(),actualUser.getfirstName());
        assertEquals(expectedUser.getlastName(),actualUser.getlastName());
        assertEquals(expectedUser.getadress(),actualUser.getadress());
        assertEquals(expectedUser.getemail(),actualUser.getemail());
        assertEquals(expectedUser.getpassword(),actualUser.getpassword());
        assertEquals(expectedUser.getuserName(),actualUser.getuserName());
    }

    @org.junit.jupiter.api.Test
    void putArticleTest() throws SQLException {
        // act
        Article article = backend.createArticle("ArticleTest", "ArticleTest", "ArticleTest",
                (float)2.00, "ArticleTest", 50);



        Article expectedArticle = new Article_InMemoryImpl("ArticleTest", article.getIDarticle(), (float)2.00,
                "ArticleTest", "ArticleTest", "ArticleTest", 50);

        Article actualArticle = Article_JdbcImpl.getArticleById(article.getIDarticle());

        // assert
        assertEquals(expectedArticle.getArticleName(),actualArticle.getArticleName());
        assertEquals(expectedArticle.getPrice(),actualArticle.getPrice());
        assertEquals(expectedArticle.getcategory(),actualArticle.getcategory());
        assertEquals(expectedArticle.getcolor(),actualArticle.getcolor());
        assertEquals(expectedArticle.getgender(),actualArticle.getgender());
    }

    @org.junit.jupiter.api.Test
    void putOrderTest() throws SQLException, OutOfStockException, ParseException, ImpossibleBirthdateException {
        // arrange
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/01/2022");
        Customer customer = backend.createCustomer("Usertest", "Usertest", "Usertest", "Usertest",
                "Usertest", date, "34342343", "Usertest", "Usertest");
        int IDcustomer = customer.getIDcustomer();

        Article article1 = backend.createArticle("ArticleTest", "ArticleTest", "ArticleTest",
                (float)2.00, "ArticleTest", 50);
        int expectedIDarticle1 = article1.getIDarticle();
        int expectedAmount1 = 5;

        Article article2 = backend.createArticle("ArticleTest", "ArticleTest", "ArticleTest",
                (float)2.00, "ArticleTest", 50);
        int expectedIDarticle2 = article2.getIDarticle();
        int expectedAmount2 = 5;

        ArrayList<CartDetails> arrayOfCartDetails = new ArrayList<>();
        Cart_JdbcImpl cart = new Cart_JdbcImpl(arrayOfCartDetails, IDcustomer);
        cart.addItems(expectedIDarticle1, expectedAmount1);
        cart.addItems(expectedIDarticle2, expectedAmount2);

        // act
        CheckoutController_JdbcImpl checkoutController = (CheckoutController_JdbcImpl)backend.createOrder(cart);
        int IDorder = checkoutController.getIDorder();

        ArrayList<Integer> actualAmounts = CheckoutController_JdbcImpl.getAmountByIDorder(IDorder);
        ArrayList<Integer> actualIDarticles = CheckoutController_JdbcImpl.getFSarticlesByIDorder(IDorder);

        // assert
        assertEquals(expectedAmount1, actualAmounts.get(0));
        assertEquals(expectedAmount2, actualAmounts.get(1));
        assertEquals(expectedIDarticle1, actualIDarticles.get(0));
        assertEquals(expectedIDarticle2, actualIDarticles.get(1));
    }

    @org.junit.jupiter.api.Test
    void ArticleOutOfStockTest() throws SQLException, OutOfStockException {
        // arrange
        Article article = backend.createArticle("ArticleTest", "ArticleTest", "ArticleTest",
                (float)2.00, "ArticleTest", 0);
        int IDarticle = article.getIDarticle();
        int Amount = 5;

        ArrayList<CartDetails> arrayOfCartDetails = new ArrayList<>();
        Cart_JdbcImpl cart = new Cart_JdbcImpl(arrayOfCartDetails, 1);

        // act / assert
        Exception exception = assertThrows(OutOfStockException.class, () -> cart.addItems(IDarticle, Amount));
        assertEquals("Article is out of stock!", exception.getMessage());

    }
}