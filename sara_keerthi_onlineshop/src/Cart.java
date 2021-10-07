import com.sun.xml.internal.bind.v2.model.core.ID;

public class Cart {
    private int IDcart;
    private Article arrayOfArticles[];
    private Customer customer;

    public Cart(int IDcart, Article arrayOfArticles[]){
        this.IDcart = IDcart;
        this.arrayOfArticles = arrayOfArticles;

    }

    public Order createOrder(){
        return null;
    }

}
