package models;

import java.sql.SQLException;
/**
 * Abstract Customer Class
 */
/** for customer registration */
public abstract class Customer{
    private int IDcustomer;
    public abstract void delete() throws SQLException;
    public abstract int getIDcustomer();
}
