public class CheckoutController {

    public String CheckOut(Cart cart){
        if(cart.getArrayOfCartDetails().size() < 1){
            System.out.println("Cart is empty");
            return null;
        }
        Order order = cart.createOrder();
        String bill = order.generateBill();
        return "Checkout successful.\n" + bill;
    }

}
