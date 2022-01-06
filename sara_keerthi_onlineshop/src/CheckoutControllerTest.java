import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CheckoutControllerTest {
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
    Order one;
    @Mock
    ArrayList<CartDetails> arrayOfCart;

    @BeforeEach
    void setup(){

        // ArrayList erstellt, in dieser ArrayList wird dann die Artikel hinzugefügt
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