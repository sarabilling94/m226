import java.util.ArrayList;

public class Cart {
    //private int IDcart;
    private ArrayList<CartDetails> arrayOfCartDetails;
    private Customer customer;

    public Cart(ArrayList<CartDetails> arrayOfArticles, Customer customer){
       // this.IDcart = IDcart;
        this.arrayOfCartDetails = arrayOfArticles;
        this.customer = customer;
    }

    public ArrayList<CartDetails> getArrayOfCartDetails() {
        return arrayOfCartDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order createOrder(){
        Order order = new Order(this.arrayOfCartDetails, this.customer);
        return order;
    }

}
