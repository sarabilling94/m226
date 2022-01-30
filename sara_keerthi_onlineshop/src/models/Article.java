package models;

public abstract class Article {
    private String articleName;
    private int IDarticle;
    private float price;
    private String color;
    private String category;
    private String gender;
    private int inStock;

    public abstract void setArticleName(String name);

    public abstract String getArticleName();


    public abstract void setIDarticle(int id);

    public abstract int getIDarticle();


    public abstract void setPrice(float price);

    public abstract float getPrice();


    public abstract void setcolor(String color);

    public abstract String getcolor();


    public abstract void setcategory(String category);

    public abstract String getcategory();


    public abstract void setgender(String gender);

    public abstract String getgender();


    /** sets how many of this article are in stock. can't be negative */
    public abstract void setinStock(int amount);

    public abstract int getinStock();

    public abstract void delete();

}
