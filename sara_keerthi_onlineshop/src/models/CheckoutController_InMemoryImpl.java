package models;
/**
 * In Memory implementation of Article
 */
public class CheckoutController_InMemoryImpl extends CheckoutController{
    public String CheckOut(Cart cart){
        if(cart.getArrayOfCartDetails().size() < 1){
            System.out.println("models.Cart is empty");
            return null;
        }
        Order order = cart.createOrder();
        String bill = order.generateBill();
        return "Checkout successful.\n" + bill;
    }
}
