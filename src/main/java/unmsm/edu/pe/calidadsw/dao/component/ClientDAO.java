package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IClientDAO;
import unmsm.edu.pe.calidadsw.dao.model.Client;

public class ClientDAO implements IClientDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("ClientDAO");

    public ClientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(Client client) {
        Boolean result = false;
        String sql = "{CALL sp_insert_client(?,?,?,?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setString(1, client.getName());
            callableStatement.setString(2, client.getLastname());
            callableStatement.setString(3, client.getDni());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            callableStatement.setString(4, formatter.format(client.getBirthdate()));
            callableStatement.setString(5, client.getTelephone());
            callableStatement.setString(6, client.getMail());
            callableStatement.setString(7, client.getUsername());
            callableStatement.setString(8, client.getPassword());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");
                    /**
                     * response: 1 Correct; 2 DNI already exists
                     */

                    switch (response) {
                    case 0:
                        LOGGER.log(Level.WARNING, "Error to execute procedure.");
                        break;
                    case 1:
                        result = true;
                        LOGGER.log(Level.INFO, "Insert successfully.");
                        break;
                    case 2:
                        LOGGER.log(Level.WARNING, "The dni number already exists.");
                        break;
                    default:
                        LOGGER.log(Level.WARNING, "Default.");
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;
    }
}
