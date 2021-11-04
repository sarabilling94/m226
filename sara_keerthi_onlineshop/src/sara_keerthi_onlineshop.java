import java.util.ArrayList;
import java.util.Date;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) {


        Employee employee = new Employee(1, "test", "123", "test", "test"
        ,"test", "sdd@kdf.ch", new Date("01-01-2021"), "000000001", "female", true );

        Customer customer = new Customer(1, "test", "123", "test", "test",
                "test", "sdff@dkfmdfm.ch");

        Cart cart = new Cart(new ArrayList<CartDetails>(), customer );

        Article article = new Article("test", 1, 2, "red", "test",
                "test", 10);

        cart.addItems(article, 2);

        CheckoutController checkout = new CheckoutController();
        checkout.CheckOut(cart);

    }
}
