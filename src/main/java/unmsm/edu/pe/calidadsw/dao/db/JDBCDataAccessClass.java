package unmsm.edu.pe.calidadsw.dao.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    private static final Logger LOGGER = Logger.getLogger("JDBCDataAccessClass");

    public JDBCDataAccessClass() {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("server.txt"));) {
            String[] datos = new String[3];
            String linea = br.readLine();

            while (linea != null && contador < 3) {
                datos[contador] = linea;
                linea = br.readLine();
                contador++;
            }

            this.jdbcURL = datos[0];
            this.jdbcUsername = datos[1];
            this.jdbcPassword = datos[2];
        } catch (Exception e1) {
            LOGGER.log(Level.SEVERE, e1.getMessage());
        }
    }

    public Connection getJdbcConnection() {
        Connection jdbcConnection = null;

        try {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return jdbcConnection;
    }
}
