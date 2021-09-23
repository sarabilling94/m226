public class Article {
    private String articleName;
    private int IDarticle;
    private float price;
    private String color;
    private String category;
    private String gender;
    private int inStock;
    private int amountAdded;

    //constructor
    public Article(String articleName, int IDarticle, float price, String color, String category, String gender, int inStock, int amountAdded){
        this.articleName = articleName;
        this.IDarticle = IDarticle;
        this.price = price;
        this.color = color;
        this.category = category;
        this.gender = gender;
        this.inStock = inStock;
        this.amountAdded = amountAdded;
    }

    public void setArticleName(String name){
        this.articleName = name;
    }

    public String getArticleName(){
        return this.articleName;
    }


    public void setIDarticle(int id){
        this.IDarticle = id;
    }

    public int getIDarticle(){
        return this.IDarticle;
    }


    public void setprice(float price){
        this.price = price;
    }

    public float getprice(){
        return this.price;
    }


    public void setcolor(String color){
        this.color = color;
    }

    public String getcolor(){
        return this.color;
    }


    public void setcategory(String category){
        this.category = category;
    }

    public String getcategory(){
        return this.category;
    }


    public void setgender(String gender){
        this.gender = gender;
    }

    public String getgender(){
        return this.gender;
    }


    public void setinStock(int amount){
        this.inStock = amount;
    }

    public int getinStock(){
        return this.inStock;
    }


    public void setamountAdded(int amount){
        this.amountAdded = amount;
    }

    public int getamountAdded(){
        return this.amountAdded;
    }

    public float calculatePrice(){
        return amountAdded * price;
    }

}
