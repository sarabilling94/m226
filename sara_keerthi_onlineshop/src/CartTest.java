import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    CartDetails cartDetails1, cartDetails2, cartDetails3;
    Customer customer1;
    @BeforeEach
    void setup(){
        Article article1 = new Article("Schuhe", 1, 250.00f, "blau", "Schuhe", "weiblich", 10);
        Article article2 = new Article("Kette", 1, 250.00f, "blau", "Schuhe", "weiblich", 10);
        Article article3 = new Article("Kleid", 1, 250.00f, "blau", "Schuhe", "weiblich", 10);
        cartDetails1 = new CartDetails(article1, 5);
        cartDetails2 = new CartDetails(article1, 10);
        cartDetails3 = new CartDetails(article1, 15);
        customer1 = new Customer(1, "Muster", "muster", "Muster", "Meier", "Schulstrasse 3a", "hdgcfjl@hotmail.com");
    }
    @org.junit.jupiter.api.Test
    void createOrder() {
        ArrayList<CartDetails> arrayOfCart = new ArrayList<>();
        arrayOfCart.add(cartDetails1);
        arrayOfCart.add(cartDetails2);
        arrayOfCart.add(cartDetails3);

        Cart cart = new Cart(arrayOfCart, customer1);
        Order one = cart.createOrder();
        assertEquals(customer1, one.getCustomer());
    }
}