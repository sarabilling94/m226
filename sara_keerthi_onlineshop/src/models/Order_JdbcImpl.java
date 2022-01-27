package models;

import java.util.ArrayList;
import java.util.Date;

public class Order_JdbcImpl {
    private final int IDuser;
    private ArrayList<CartDetails> arrayOfDetails;
    private Customer customer;
    private Date date = java.util.Calendar.getInstance().getTime();

    private Order_JdbcImpl(ArrayList<CartDetails> arrayOfDetails, Customer customer){

    }
}
