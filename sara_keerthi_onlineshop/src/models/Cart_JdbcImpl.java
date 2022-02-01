package models;

import java.util.ArrayList;

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
    public String addItems(int IDarticle, int amount){
        int newInStock = Article_JdbcImpl.getinStock(IDarticle) - amount;
        if(newInStock >= 0){
            arrayOfCartDetails.add(new CartDetails(Article_JdbcImpl.getArticleById(IDarticle), amount));
            Article_JdbcImpl.setinStock(newInStock, IDarticle);
            return "Articles added.";
        }
        else{
            return "Not enough in stock. There are only " + Article_JdbcImpl.getinStock(IDarticle) + " left.";
        }
    }
}
