package unmsm.edu.pe.calidadsw.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antony
 */
public class JDBCDataAccessClass {
    private String jdbcURL = null;
    private String jdbcUsername = null;
    private String jdbcPassword = null;
    private static final Logger LOGGER = Logger.getLogger(JDBCDataAccessClass.class.getName());

    public JDBCDataAccessClass() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            this.jdbcURL = props.getProperty("jdbc.database.url");
            this.jdbcUsername = props.getProperty("jdbc.database.username");
            this.jdbcPassword = props.getProperty("jdbc.database.password");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     * 
     * @return
     */
    public Connection getJdbcConnection() {
        Connection jdbcConnection = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            jdbcConnection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return jdbcConnection;
    }
}
