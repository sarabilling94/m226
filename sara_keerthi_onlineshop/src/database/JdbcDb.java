package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton implementation for jdbc connection
 */
public class JdbcDb {
    /**
     * public access method to the JDBC connection
     *
     * @return JDBC Connection
     */
    public static Connection getConnection() {
        return ConnectionHolder.connection;
    }

    /**
     * Connection Holder Class to store the JDBC connection.
     */
    private static final class ConnectionHolder {
        private static Connection connection;

        static {
            try {
                connection = DriverManager.getConnection(Configuration.jdbcUrl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
