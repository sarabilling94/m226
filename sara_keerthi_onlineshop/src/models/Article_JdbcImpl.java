package models;

import database.JdbcDb;

import java.sql.*;

/**
 * JDBC implementation of Person
 */
public class Article_JdbcImpl extends Article {
    private final int IDarticle;

    public Article_JdbcImpl(String articleName, int IDarticle, float price, String color, String category, String gender, int inStock) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement Article_stmt = conn.prepareStatement("insert into tbl_person (idArticle, articleName, price, color, category, gender, inStock) values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        Article_stmt.setString(1, IDarticle);
        Article_stmt.setString(2, articleName);
        Article_stmt.setString(3, price);
        Article_stmt.setString(4, color);
        Article_stmt.setString(5, category);
        Article_stmt.setString(6, gender);
        Article_stmt.setBoolean(7, true);
        Article_stmt.executeUpdate();
        ResultSet Article_res = Article_stmt.getGeneratedKeys();
        Article_res.next();
        IDarticle = Article_res.getInt("ID_article");
    }

    private Article_JdbcImpl(int IDarticle) {
        this.IDarticle = IDarticle;
    }

    public static Article_JdbcImpl getById(int IDarticle) {
        return new Article_JdbcImpl(IDarticle);
    }


    @Override
    public String getArticleName() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("select articlename from tbl_article where id_article=?");
            Article_stmt.setInt(1, IDarticle);
            Article_stmt.execute();
            ResultSet res = Article_stmt.getResultSet();
            res.next();
            return res.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setArticleName(String articleName) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getIDarticle() {
        return null;
    }

    @Override
    public void setIDarticle(String iDarticle) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public void setPrice(String price) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getcolor() {
        return null;
    }

    @Override
    public void setcolor(String color) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getcategory() {
        return null;
    }

    @Override
    public void setcategory(String category) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public String getgender() {
        return null;
    }

    @Override
    public void setgender(String gender) {
        throw new RuntimeException("Not implemented yet");
    }



    @Override
    public void delete() {

        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("delete from tbl_article where ID_Articler=?");
            Article_stmt.setInt(1, IDarticle);
            Article_stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}