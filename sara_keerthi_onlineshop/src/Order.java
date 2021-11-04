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
        int total = arrayOfDetails.stream().mapToInt(details -> (int) (details.getArticle().getPrice() * details.getAmount())).sum();
    return "Your total is: " + total;
    }

    public ArrayList<CartDetails> getArrayOfDetails() {
        return arrayOfDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }
}
