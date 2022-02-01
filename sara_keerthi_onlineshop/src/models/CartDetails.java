package models;

/** needed to store several units of an article in the cart */
public class CartDetails {
    private Article_InMemoryImpl article;
    private int amount;

    public CartDetails(Article_InMemoryImpl article, int amount) {
        this.article = article;
        this.amount = amount;
    }

    public Article_InMemoryImpl getArticle(){
        return this.article;
    }

    public int getAmount(){
        return this.amount;
    }
}
