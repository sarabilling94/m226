public class CheckoutController {
    //for checkout after choosing articles to buy. creates the order and generates the bill.
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
