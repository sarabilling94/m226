package utils;

// Exception Class thrown if you try to add an article to the cart when it's out of stock
public class OutOfStockException extends Exception{
    public OutOfStockException(String errorMessage){
        super(errorMessage);
    }
}
