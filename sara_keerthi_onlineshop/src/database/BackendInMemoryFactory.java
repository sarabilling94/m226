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

    public Customer createCustomer(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException {
        Random rand = new Random();
        int IDuser = rand.nextInt();
        return new Customer_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort);
    }

    public Employee createEmployee(String vorname, String nachname, String adresse, String email, String username, String passwort, LocalDate birthday, String phone, String gender, boolean admin) throws SQLException {
        Random rand = new Random();
        int IDuser = rand.nextInt();
        return new Employee_InMemoryImpl(IDuser, vorname, nachname, adresse, email, username, passwort, birthday, phone, gender, admin);
    }

    public Article createArticle(String bezeichnung, int IDarticle, float preis, String farbe, String kategorie, String geschlecht, int aufLager) throws SQLException {
        return new Article_InMemoryImpl(bezeichnung, IDarticle, preis, farbe, kategorie, geschlecht, aufLager);
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
}
