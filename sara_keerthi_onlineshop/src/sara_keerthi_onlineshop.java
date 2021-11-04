import java.time.LocalDate;
import java.util.ArrayList;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) {

        Employee employee = new Employee(1, "test", "123", "test", "test"
        ,"test", "sdd@kdf.ch", LocalDate.of(2020, 1, 8), "000000001", "female", true );

        Customer customer = new Customer(1, "test", "123", "test", "test",
                "test", "sdff@dkfmdfm.ch");

        Cart cart = new Cart(new ArrayList<CartDetails>(), customer );

        Article article = new Article("Hose", 1, 2, "red", "test",
                "test", 10);

        Article article2 = new Article("Shirt", 1, 2, "red", "test",
                "test", 10);

        cart.addItems(article, 2);
        cart.addItems(article2, 3);

        CheckoutController checkout = new CheckoutController();
        String confirmation = checkout.CheckOut(cart);

        System.out.println(confirmation);

    }
}
