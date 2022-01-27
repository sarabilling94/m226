package database;

import models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
        return new User_InMemoryImpl(vorname, nachname, adresse, email, username, passwort);
    }

    public Article createArticle(String bezeichnung, int IDarticle, float preis, String farbe, String kategorie, String geschlecht, int aufLager) throws SQLException {
        return new Article(bezeichnung, IDarticle, preis, farbe, kategorie, geschlecht, aufLager);
    }

    public Order createOrder(ArrayList<CartDetails> arrayOfDetails, Customer kunde) throws SQLException {
        return new Order(arrayOfDetails, kunde);
    }

    public CartDetails createCartDetails(Article artikel, int anzahl) throws SQLException {
        return new CartDetails(artikel, anzahl);
    }

    public CartDetails createCartDetails(Article artikel, int anzahl) throws SQLException {
        return new CartDetails(artikel, anzahl);
    }
}
