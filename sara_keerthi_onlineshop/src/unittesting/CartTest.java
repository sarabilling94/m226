package unittesting;

import models.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    // Hier werden die Setups gemacht damit wir die unter Tests ausführen können
    Article article1, article2, article3;
    CartDetails cartDetails1, cartDetails2, cartDetails3;
    Customer customer1;
    Cart cart;
    ArrayList<CartDetails> arrayOfCart;

    @BeforeEach
    void setup(){
        //mock articles, cartdetails
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

        //neue models.Cart erstellt. Pro models.Cart ein models.Customer
        cart = new Cart(arrayOfCart, customer1);
    }

    // Hier fängt dann testing an für Methode createOrder()
    @org.junit.jupiter.api.Test
    void createOrderTest() {
        //neue models.Order erstellt
        Order one = cart.createOrder();

        //sollte alles true sein
        //details nicht testen
        assertEquals(customer1, one.getCustomer());
        assertEquals(article1, one.getArrayOfDetails().get(0).getArticle());
        assertEquals(article2, one.getArrayOfDetails().get(1).getArticle());
        assertEquals(article3, one.getArrayOfDetails().get(2).getArticle());
        assertEquals(5, one.getArrayOfDetails().get(0).getAmount());
        assertEquals(10, one.getArrayOfDetails().get(1).getAmount());
        assertEquals(15, one.getArrayOfDetails().get(2).getAmount());
    }

    // Hier fängt dann testing an für Methode addItems()
    @org.junit.jupiter.api.Test
    void addItemsTest() {
        //addItems aufgerufen
        cart.addItems(article1, 5);
        cart.addItems(article2,10);
        cart.addItems(article3, 15);

        //alles sollte true sein
        assertEquals(5, article1.getinStock());
        assertEquals(0, article2.getinStock());
        assertEquals("Not enough in stock. There are only 10 left.", cart.addItems(article3, 15));
    }

}