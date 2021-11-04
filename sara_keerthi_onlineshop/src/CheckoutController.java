public class CheckoutController {

    public void CheckOut(Cart cart){
        Order order = cart.createOrder();
        System.out.println(order.generateBill());
    }

}
