package database;

import models.*;
import utils.ImpossibleBirthdateException;

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
    public abstract Article createArticle(String articleName, String gender, String category, float price, String color, int inStock)  throws SQLException;
    public abstract CheckoutController createOrder(Cart_JdbcImpl cart) throws SQLException;
    public abstract Customer createCustomer(String vorname, String nachname, String adresse, String email, String username, Date birthday, String phone, String gender, String passwort) throws SQLException, ImpossibleBirthdateException;
    public abstract Employee createEmployee(String vorname, String nachname, String adresse, String email, String username, String passwort, Date geburtstag, String geschlecht, String telefon, boolean admin) throws SQLException, ImpossibleBirthdateException;

}
