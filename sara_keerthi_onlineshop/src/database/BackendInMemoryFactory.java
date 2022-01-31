package database;

import models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Singelton Class for InMemory Factory
 * Returns objects of the Classes ....InMemory_Impl
 */
public class BackendInMemoryFactory extends BackendFactory {
    private static final BackendFactory factory=new BackendInMemoryFactory();
    public static BackendFactory getFactory() {
        return factory;
    }

    public User createUser(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException {
        Random rand = new Random();
        int IDuser = rand.nextInt();
        return new User_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort);
    }

    public Customer createCustomer(String vorname, String nachname, String adresse, String email, String username, Date birthday, String phone, String gender, String passwort) throws SQLException {
        Random rand = new Random();
        int IDuser = rand.nextInt();
        return new Customer_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort);
    }

    public Employee createEmployee(String vorname, String nachname, String adresse, String email, String username, String passwort, Date birthday, String phone, String gender, boolean admin) throws SQLException {
        Random rand = new Random();
        int IDuser = rand.nextInt();
        return new Employee_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort, birthday, phone, gender, admin);
    }

    public Article createArticle(String articleName, String gender, String category, float price, String color, int inStock) throws SQLException {
        Random rand = new Random();
        int IDarticle = rand.nextInt();
        return new Article_InMemoryImpl(articleName, IDarticle, price, color, category, gender, inStock);
    }

    public Order createOrder(ArrayList<CartDetails> arrayOfDetails, Customer kunde) throws SQLException {
        return new Order_InMemoryImpl(arrayOfDetails, kunde);
    }

    public CartDetails createCartDetails(Article artikel, int anzahl) throws SQLException {
        return new CartDetails(artikel, anzahl);
    }

    public Cart createCart(ArrayList<CartDetails> arrayOfCartDetails, Customer customer){
        return new Cart(arrayOfCartDetails, customer);
    }

    public CheckoutController createOrder(Cart cart){
        return new CheckoutController_InMemoryImpl();
    }
}
