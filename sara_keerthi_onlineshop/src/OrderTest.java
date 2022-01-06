import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderTest {
    // Hier werden die Setups gemacht damit wir die unter Tests ausführen können
    @Mock
    Article article1, article2, article3;
    @Mock
    CartDetails cartDetails1, cartDetails2, cartDetails3;
    @Mock
    Customer customer1;
    @Mock
    Cart cart;
    @Mock
    Order two;
    @Mock
    ArrayList<CartDetails> arrayOfCart;

    @BeforeEach
    void setup(){
        article1 = new Article("Schuhe", 1, 1.00f, "blau", "Schuhe", "weiblich", 5);
        article2 = new Article("Kette", 2, 1.00f, "blau", "Schuhe", "weiblich", 10);
        article3 = new Article("Armband", 3, 1.00f, "blau", "Schuhe", "weiblich", 15);
        cartDetails1 = new CartDetails(article1, 5);
        cartDetails2 = new CartDetails(article2, 10);
        cartDetails3 = new CartDetails(article3, 15);
        customer1 = new Customer(1, "Muster", "muster", "Muster", "Meier", "Schulstrasse 3a", "hdgcfjl@hotmail.com");

        // ArrayList erstellt, in dieser ArrayList wird dann die Artikel hinzugefügt
        arrayOfCart = new ArrayList<>();
        arrayOfCart.add(cartDetails1);
        arrayOfCart.add(cartDetails2);
        arrayOfCart.add(cartDetails3);

        //neuer Cart erstellt. Pro Cart ein Customer
        cart = new Cart(arrayOfCart, customer1);

        //neuer Order
        two = cart.createOrder();
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
        two.generateBill();

        //sollte true sein
        assertEquals(customer1, two.getCustomer());
        assertEquals(arrayOfCart, two.getArrayOfDetails());
        assertEquals(java.util.Calendar.getInstance().getTime().toString(), two.getDate().toString());
        assertEquals("Article: Schuhe | Amount: 5\n" +
                "Article: Kette | Amount: 10\n" +
                "Article: Armband | Amount: 15\n" +
                "Total: 30 $", two.generateBill());
    }

}