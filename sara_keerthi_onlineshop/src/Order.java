import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<CartDetails> arrayOfDetails;
    private Customer customer;
    private Employee employee;
    private Date date;

    public Order(ArrayList<CartDetails> arrayOfDetails, Customer customer, Employee employee, Date date){
        this.arrayOfDetails = arrayOfDetails;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
    }
}
