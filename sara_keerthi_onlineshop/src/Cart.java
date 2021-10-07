import java.util.ArrayList;

public class Cart {
    private int IDcart;
    private ArrayList<CartDetails> arrayOfCartDetails;
    private Customer customer;

    public Cart(int IDcart, ArrayList<CartDetails> arrayOfArticles){
        this.IDcart = IDcart;
        this.arrayOfCartDetails = arrayOfArticles;

    }

    public Order createOrder(){
        return null;
    }

}
