/** needed to store several units of an article in the cart */
public class CartDetails {
    private Article article;
    private int amount;

    public CartDetails(Article article, int amount) {
        this.article = article;
        this.amount = amount;
    }

    public Article getArticle(){
        return this.article;
    }

    public int getAmount(){
        return this.amount;
    }
}
