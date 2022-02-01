package database;

import models.*;

import java.sql.SQLException;
import java.util.Date;

/**
 * Singleton Class for Jdbc Factory
 * Returns objects of the Classes ....Jdbc_Impl
 */
public class BackendJdbcFactory extends BackendFactory {
    private static final BackendFactory factory=new BackendJdbcFactory();
    public static BackendFactory getFactory() {
        return factory;
    }

    public User createUser(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException {
        return new User_JdbcImpl(vorname, nachname, adresse, email, username, passwort);
    }

    public Customer createCustomer(String vorname, String nachname, String adresse, String email, String username, Date birthday, String phone, String gender, String passwort) throws SQLException{
        return new Customer_JdbcImpl(vorname, nachname, adresse, email, username, birthday, phone, gender, passwort);
    }

    public Employee createEmployee(String vorname, String nachname, String adresse, String email, String username, String passwort, Date geburtstag, String geschlecht, String telefon, boolean admin) throws SQLException{
        return new Employee_JdbcImpl(vorname, nachname, adresse, email, username, passwort, geburtstag, geschlecht, telefon, admin);
    }

    public Article createArticle(String articleName, String gender, String category, float price, String color, int inStock) throws SQLException {
        return new Article_JdbcImpl(articleName, gender, category, price, color, inStock);
    }

    public CheckoutController createOrder(Cart_JdbcImpl cart) throws SQLException {
        return new CheckoutController_JdbcImpl(cart);
    }
}
