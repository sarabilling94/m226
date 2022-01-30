package models;

public class CheckoutController_InMemoryImpl {
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