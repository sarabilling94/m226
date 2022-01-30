package models;

import database.JdbcDb;

import java.sql.*;

/**
 * JDBC implementation of Person
 */
public class Article_JdbcImpl extends Article {
    private final int IDarticle;

    public Article_JdbcImpl(String articleName, String gender, String category, float price, String color, int inStock) throws SQLException {
        Connection conn = JdbcDb.getConnection();
        PreparedStatement Article_stmt = conn.prepareStatement("insert into tbl_artikel (bezeichnung, geschlecht, kategorie, preis, color, inStock) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        Article_stmt.setString(2, articleName);
        Article_stmt.setString(3, gender);
        Article_stmt.setString(4, category);
        Article_stmt.setFloat(5, price);
        Article_stmt.setString(6, gender);
        Article_stmt.setBoolean(7, true);
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

    @Override
    public int getinStock() {
        return 0;
    }

    @Override
    public void setinStock(int amount) {
        throw new RuntimeException("Not implemented yet");
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