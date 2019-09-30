package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IClientDAO;
import unmsm.edu.pe.calidadsw.dao.model.Client;;

public class ClientDAO implements IClientDAO{
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("ClientDAO");

    public ClientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(Client client) {
        Boolean result = true;
        String sql = "{CALL sp_insert_client(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, client.getName());
            callableStatement.setString(2, client.getLastname());
            callableStatement.setString(3, client.getDni());
            callableStatement.setDate(4, (Date) client.getBirthdate());
            callableStatement.setString(5, client.getTelephone());
            callableStatement.setString(6, client.getMail());
            callableStatement.setString(7, client.getUsername());
            callableStatement.setString(8, client.getPassword());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure create.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }
}
