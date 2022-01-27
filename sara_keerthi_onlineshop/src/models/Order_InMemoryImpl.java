package models;

import java.util.ArrayList;
import java.util.Date;

public class Order_InMemoryImpl extends Order{
    private final static ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<CartDetails> arrayOfDetails;
    private Customer customer;
    private Date date = java.util.Calendar.getInstance().getTime();

    public Order_InMemoryImpl(String vorname, String nachname, String adresse, String email, String username, String passwort, Date birthday, String phone, String gender, ArrayList<CartDetails> arrayOfDetails){
        customer = new Customer_InMemoryImpl(vorname, nachname, adresse, email, username, passwort, birthday, phone, gender);
        this.arrayOfDetails = arrayOfDetails;

        orders.add(this);
    }

    public String generateBill(){
        int total = arrayOfDetails.stream().mapToInt(details -> (int) (details.getArticle().getPrice() * details.getAmount())).sum();
        String bill = "";
        for(int i = 0; i < arrayOfDetails.size(); i++){
            bill = bill + "models.Article: " + arrayOfDetails.get(i).getArticle().getArticleName() + " | Amount: " + arrayOfDetails.get(i).getAmount() +"\n";
        }
        bill  += "Total: " + total + " $";
        return bill;
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