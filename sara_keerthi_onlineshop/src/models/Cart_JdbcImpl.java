package models;

import utils.OutOfStockException;

import java.util.ArrayList;
/**
 * JDBC implementation of Cart
 */
/** the customers cart that contains the chosen articles */
public class Cart_JdbcImpl {
    private ArrayList<CartDetails> arrayOfCartDetails;
    private int IDcustomer;

    public Cart_JdbcImpl(ArrayList<CartDetails> arrayOfArticles, int IDcustomer){
        this.arrayOfCartDetails = arrayOfArticles;
        this.IDcustomer = IDcustomer;
    }

    public ArrayList<CartDetails> getArrayOfCartDetails() {
        return arrayOfCartDetails;
    }

    public int getIDcustomer() {
        return IDcustomer;
    }

    /** adds a certain amount of an article to a cart.
     returns a string to confirm whether article has been added or not. */
    public String addItems(int IDarticle, int amount) throws OutOfStockException {
        int newInStock = Article_JdbcImpl.getinStock(IDarticle) - amount;
        if(newInStock >= 0){
            arrayOfCartDetails.add(new CartDetails(Article_JdbcImpl.getArticleById(IDarticle), amount));
            Article_JdbcImpl.setinStock(newInStock, IDarticle);
            return "Articles added.";
        }
        else{
            throw new OutOfStockException("Article is out of stock!");
        }
    }
}
