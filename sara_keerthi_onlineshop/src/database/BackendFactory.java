package database;

import models.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Backend Factory Class which defines all Factory Methods.
 */
public abstract class BackendFactory {
    /**
     * This method is calling the right Factory class's getFactory method and returns the right Factory
     * according to the Configuration.hibernation field
     * @return BackendFactory
     */
    public static BackendFactory getFactory(){
        if (Configuration.hibernation == Configuration.hibernationType.inMemory)
            return BackendInMemoryFactory.getFactory();
        if (Configuration.hibernation == Configuration.hibernationType.jdbc)
            return BackendJdbcFactory.getFactory();
        throw new RuntimeException(Configuration.hibernation + " not implemented yet");
    }

    public abstract User createUser(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException;
    public abstract Article createArticle(String bezeichnung, int IDarticle, float preis, String farbe, String kategorie, String geschlecht, int aufLager)  throws SQLException;
    public abstract Order createOrder(ArrayList<CartDetails> arrayOfDetails, Customer kunde) throws SQLException;
    public abstract CartDetails createCartDetails(Article artikel, int anzahl) throws SQLException;
    public abstract Customer createCustomer(String vorname, String nachname, String adresse, String email, String username, String passwort) throws SQLException;
    public abstract Employee createEmployee(String vorname, String nachname, String adresse, String email, String username, String passwort, LocalDate birthday, String phone, String gender, boolean admin) throws SQLException;

    //function for getting foreignkeys?
}
