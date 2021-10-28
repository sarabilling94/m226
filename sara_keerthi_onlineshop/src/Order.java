import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<CartDetails> arrayOfDetails;
    private Customer customer;
    private Date date = java.util.Calendar.getInstance().getTime();

    public Order(ArrayList<CartDetails> arrayOfDetails, Customer customer){
        this.arrayOfDetails = arrayOfDetails;
        this.customer = customer;
    }

    public String generateBill(){
        int total = 0;
        arrayOfDetails.forEach(details -> {
            total += details.get
        });

    }
}
