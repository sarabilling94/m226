import models.Article;
import models.Cart;
import models.CheckoutController;
import models.Customer;

import java.util.ArrayList;

public class sara_keerthi_onlineshop {

    public static void main(String[] args) {

        Customer customer = new Customer(1, "test", "123", "test", "test",
                "test", "sdff@dkfmdfm.ch");

        Cart cart = new Cart(new ArrayList<>(), customer );

        Article article = new Article("Hose", 9999, 2, "red", "test",
                "test", 10);

        Article article2 = new Article("Shirt", 9998, 2, "red", "test",
                "test", 10);

        cart.addItems(article, 2);
        cart.addItems(article2, 3);

        CheckoutController checkout = new CheckoutController();
        String confirmation = checkout.CheckOut(cart);

        System.out.println(confirmation);
        
        

    }
}
