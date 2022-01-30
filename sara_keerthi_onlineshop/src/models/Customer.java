package models;

import java.sql.SQLException;

/** for customer registration */
public abstract class Customer{
    private int IDcustomer;
    public abstract void delete() throws SQLException;
}
