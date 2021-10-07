import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @BeforeAll
    void setup(){
        Article article1 = new Article("Schuhe", 1, 250.00, "blau", "Schuhe", "weiblich", 10);
        Article article2 = new Article("Kette", 1, 250.00, "blau", "Schuhe", "weiblich", 10);
        Article article3 = new Article("Kleid", 1, 250.00, "blau", "Schuhe", "weiblich", 10);
        Customer customer1 = new Customer(1, "Muster", "muster", "Muster", "Meier", "Schulstrasse 3a", "hdgcfjl@hotmail.com");
    }
    @org.junit.jupiter.api.Test
    void createOrder() {
    }
}