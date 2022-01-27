package models;

import java.util.ArrayList;
import java.util.Date;

/** needed for checkout */
public abstract class Order {

    /** generates a bill with the articles and the total price*/
    public abstract String generateBill();

    public abstract ArrayList<CartDetails> getArrayOfDetails();

    public abstract Customer getCustomer();

    public abstract Date getDate();
}
