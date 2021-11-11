import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutControllerTest {
    // Hier werden die Setups gemacht damit wir die unter Tests ausführen können
    Article article1, article2, article3;
    CartDetails cartDetails1, cartDetails2, cartDetails3;
    Customer customer1;
    Cart cart;
    Order one;
    ArrayList<CartDetails> arrayOfCart;

    @BeforeEach
    void setup(){
        article1 = new Article("Schuhe", 1, 250.00f, "blau", "Schuhe", "weiblich", 10);
        article2 = new Article("Kette", 2, 250.00f, "blau", "Schuhe", "weiblich", 10);
        article3 = new Article("Kleid", 3, 250.00f, "blau", "Schuhe", "weiblich", 10);
        cartDetails1 = new CartDetails(article1, 5);
        cartDetails2 = new CartDetails(article2, 10);
        cartDetails3 = new CartDetails(article3, 15);
        customer1 = new Customer(1, "Muster", "muster", "Muster", "Meier", "Schulstrasse 3a", "hdgcfjl@hotmail.com");

        // ArrayList erstellt, in dieser ArrayList wird dann die Artikel hinzugefügt
        arrayOfCart = new ArrayList<>();
        arrayOfCart.add(cartDetails1);
        arrayOfCart.add(cartDetails2);
        arrayOfCart.add(cartDetails3);

        //neue Cart erstellt. Pro Cart ein Customer
        cart = new Cart(arrayOfCart, customer1);

        //neue Order erstellt
        one = cart.createOrder();
    }

    // Hier fängt dann testing an für Methode checkOut()
    @org.junit.jupiter.api.Test
    void checkOutTest() {
        //nicht testen bringt nichts
    }

}