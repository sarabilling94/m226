package database;

/**
 * The Class containing static configurations.
 * The Strings may be taken from a Resource Bundle later.
 */
public class Configuration {
    public static final hibernationType hibernation = hibernationType.jdbc;
    public static final String jdbcUrl = "jdbc:mariadb://localhost:3306/226_simple_db?user=root";
    /**
     * Hibernation Type Enumeration
     * jdbc - jdbc connection is used as backend with the jdbcUrl
     * inMemory - just in Memory Objects are used as backend.
     */
    public enum hibernationType {
        jdbc, inMemory
    }
}
