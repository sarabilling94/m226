package unittesting;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderTest {
    // Hier werden die Setups gemacht damit wir die unter Tests ausführen können
    @Mock
    Article_InMemoryImpl article1, article2, article3;
    @Mock
    CartDetails cartDetails1, cartDetails2, cartDetails3;
    @Mock
    Customer customer1;

    Cart cart;
    Order_InMemoryImpl two;
    ArrayList<CartDetails> arrayOfCart;

    @BeforeEach
    void setup(){
//        article1 = new Article("Schuhe", 1, 1.00f, "blau", "Schuhe", "weiblich", 5);
//        article2 = new Article("Kette", 2, 1.00f, "blau", "Schuhe", "weiblich", 10);
//        article3 = new Article("Armband", 3, 1.00f, "blau", "Schuhe", "weiblich", 15);
//        cartDetails1 = new CartDetails(article1, 5);
//        cartDetails2 = new CartDetails(article2, 10);
//        cartDetails3 = new CartDetails(article3, 15);
//        customer1 = new Customer(1, "Muster", "muster", "Muster", "Meier", "Schulstrasse 3a", "hdgcfjl@hotmail.com");
        // ArrayList erstellt, in dieser ArrayList wird dann die Artikel hinzugefügt
        arrayOfCart = new ArrayList<>();
        arrayOfCart.add(cartDetails1);
        arrayOfCart.add(cartDetails2);
        arrayOfCart.add(cartDetails3);

        //neuer models.Cart erstellt. Pro models.Cart ein models.Customer
        cart = new Cart(arrayOfCart, customer1);

        //neuer models.Order
        two = (Order_InMemoryImpl)cart.createOrder();
    }


    // Hier fängt dann testing an für Methode generateBill()
    @org.junit.jupiter.api.Test
    void generateBillTest() {
        when(article1.getArticleName()).thenReturn("Schuhe");
        when(article2.getArticleName()).thenReturn("Kette");
        when(article3.getArticleName()).thenReturn("Armband");
        when(cartDetails1.getAmount()).thenReturn(5);
        when(cartDetails2.getAmount()).thenReturn(10);
        when(cartDetails3.getAmount()).thenReturn(15);
        when(cartDetails1.getArticle()).thenReturn(article1);
        when(cartDetails2.getArticle()).thenReturn(article2);
        when(cartDetails3.getArticle()).thenReturn(article3);
        when(article1.getPrice()).thenReturn(1.00f);
        when(article2.getPrice()).thenReturn(1.00f);
        when(article3.getPrice()).thenReturn(1.00f);
        two.generateBill();

        //sollte true sein
        Assertions.assertEquals(customer1, two.getCustomer());
        Assertions.assertEquals(arrayOfCart, two.getArrayOfDetails());
        Assertions.assertEquals(java.util.Calendar.getInstance().getTime().toString(), two.getDate().toString());
        Assertions.assertEquals("models.Article: Schuhe | Amount: 5\n" +
                "models.Article: Kette | Amount: 10\n" +
                "models.Article: Armband | Amount: 15\n" +
                "Total: 30 $", two.generateBill());
    }

}