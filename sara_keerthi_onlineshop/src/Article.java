public class Article {
    private String articleName;
    private int IDarticle;
    private float price;
    private String color;
    private String category;
    private String gender;
    private int inStock;


    //constructor
    public Article(String articleName, int IDarticle, float price, String color, String category, String gender, int inStock){
        this.articleName = articleName;
        this.IDarticle = IDarticle;
        this.price = price;
        this.color = color;
        this.category = category;
        this.gender = gender;
        this.inStock = inStock;
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


    public  void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
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
        if(amount < 0){
            System.out.println("Amount can't be negative.");
            return;
        }
            this.inStock = amount;
    }

    public int getinStock(){
        return this.inStock;
    }

}
