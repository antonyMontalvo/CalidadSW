package unmsm.edu.pe.calidadsw.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.util.logging.Level;
// import java.util.logging.Logger;

/**
 *
 * @author antony
 */
public class JDBCDataAccessClass {
    private Connection jdbcConnection;
    private String jdbcURL = null;
    private String jdbcUsername = null;
    private String jdbcPassword = null;
    // private final static Logger LOGGER = Logger.getLogger("JDBCDataAccessClass");

    public JDBCDataAccessClass() {
        this.jdbcURL = "jdbc:mysql://159.65.248.34:3306/quality_project?useSSL=false";
        this.jdbcUsername = "";
        this.jdbcPassword = "";
    }

    public Connection getJdbcConnection() {
        jdbcConnection = null;

        try {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // LOGGER.log(Level.WARNING, "Error connect to DataBase");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // LOGGER.log(Level.WARNING, "Error connect to DataBase");
        }
        return jdbcConnection;
    }

    public void closeJdbcConnection() {
        try {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // LOGGER.log(Level.SEVERE, "Error desconnect to DataBase");
        }
    }
}
