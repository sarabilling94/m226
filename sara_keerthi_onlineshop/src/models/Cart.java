package models;

import utils.OutOfStockException;

import java.util.ArrayList;

/** the customers cart that contains the chosen articles */
public class Cart {
    private ArrayList<CartDetails> arrayOfCartDetails;
    private Customer customer;

    public Cart(ArrayList<CartDetails> arrayOfArticles, Customer customer){
        this.arrayOfCartDetails = arrayOfArticles;
        this.customer = customer;
    }

    public ArrayList<CartDetails> getArrayOfCartDetails() {
        return arrayOfCartDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    /** creates a new order based on the articles in the cart. */
    public Order createOrder(){
        Order order = new Order_InMemoryImpl(this.arrayOfCartDetails, this.customer);
        return order;
    }

    /** adds a certain amount of an article to a cart.
    returns a string to confirm whether article has been added or not. */
    public String addItems(Article_InMemoryImpl article, int amount) throws OutOfStockException {
        int newInStock = article.getinStock() - amount;
        if(newInStock >= 0){
            arrayOfCartDetails.add(new CartDetails(article, amount));
            article.setinStock(newInStock);
            return "Articles added.";
        }
        else{
            throw new OutOfStockException("Article is out of stock!");
        }
    }
}
