package models;

import database.JdbcDb;

import javax.swing.*;
import java.sql.*;

/**
 * JDBC implementation of Person
 */
public class Article_JdbcImpl extends Article {
    private final int IDarticle;

    public Article_JdbcImpl(String articleName, String gender, String category, float price, String color, int inStock) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement Article_stmt = conn.prepareStatement("insert into tbl_artikel (bezeichnung, geschlecht, kategorie, preis, color, inStock) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        Article_stmt.setString(1, articleName);
        Article_stmt.setString(2, gender);
        Article_stmt.setString(3, category);
        Article_stmt.setFloat(4, price);
        Article_stmt.setString(5, color);
        Article_stmt.setInt(6, inStock);
        Article_stmt.executeUpdate();
        ResultSet Article_res = Article_stmt.getGeneratedKeys();
        Article_res.next();
        IDarticle = Article_res.getInt("ID_artikel");
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
            PreparedStatement Article_stmt = conn.prepareStatement("select bezeichnung from tbl_artikel where ID_artikel=?");
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

    public static Article_InMemoryImpl getArticleById(int IDarticle){
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("select * from tbl_artikel where ID_artikel=?");
            Article_stmt.setInt(1, IDarticle);
            Article_stmt.execute();
            ResultSet res = Article_stmt.getResultSet();
            res.next();
            Article_InMemoryImpl article = new Article_InMemoryImpl(res.getString("bezeichnung"), res.getInt("ID_artikel"), res.getFloat("preis"),
                    res.getString("color"), res.getString("kategorie"), res.getString("geschlecht"), res.getInt("inStock") );
            return article;
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
    public int getIDarticle() {
        return IDarticle;
    }

    @Override
    public void setIDarticle(int iDarticle) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public float getPrice() {
        return 0;
    }

    @Override
    public void setPrice(float price) {
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

    public static int getinStock(int IDarticle) {
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("select inStock from tbl_artikel where ID_artikel=?");
            Article_stmt.setInt(1, IDarticle);
            Article_stmt.execute();
            ResultSet res = Article_stmt.getResultSet();
            res.next();
            return res.getInt("inStock");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setinStock(int amount, int IDarticle) {
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("update tbl_artikel set inStock=? where ID_artikel=?");
            Article_stmt.setInt(1, amount);
            Article_stmt.setInt(2, IDarticle);
            Article_stmt.executeUpdate();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void delete() {
        try {
            Connection conn = JdbcDb.getConnection();
            PreparedStatement Article_stmt = conn.prepareStatement("delete from tbl_artikel where ID_artikel=?");
            Article_stmt.setInt(1, IDarticle);
            Article_stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}