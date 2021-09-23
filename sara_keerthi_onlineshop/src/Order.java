import java.util.Date;

public class Order {
    private Article arrayOfArticles[];
    private Customer customer;
    private Employee employee;
    private Date date;

    public Order(Article arrayOfArticles[], Customer customer, Employee employee, Date date){
        this.arrayOfArticles = arrayOfArticles;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
    }
}
