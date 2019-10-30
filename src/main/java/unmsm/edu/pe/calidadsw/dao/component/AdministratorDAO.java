package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IAdministratorDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Client;

/**
 *
 * @author Usuario
 */
public class AdministratorDAO implements IAdministratorDAO {

    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger(AdministratorDAO.class.getName());

    public AdministratorDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public Administrator readLogin(String user) {
        Administrator admin = new Administrator();

        String sql = "{CALL sp_login_administrator(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setString(1, user);

            try (ResultSet resultSet = callableStatement.executeQuery();) {

                while (resultSet.next()) {

                    admin.setIdAdministrator(resultSet.getInt("idadministrator"));
                    admin.setUsername(resultSet.getString("username"));
                    admin.setPassword(resultSet.getString("password"));
                    admin.setName(resultSet.getString("name"));
                    admin.setLastname(resultSet.getString("lastname"));
                    admin.setBirthdate(resultSet.getString("birthdate"));
                }
                LOGGER.log(Level.INFO, "Admin.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return admin;
    }

    @Override
    public Boolean registerUser(Client client) {
        Boolean result = false;
        String sql = "{CALL sp_insert_client(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, client.getName());
            callableStatement.setString(2, client.getUsername());
            callableStatement.setString(3, client.getPassword());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        LOGGER.log(Level.WARNING, "Error to execute procedure.");
                    } else if (response == 1) {
                        result = true;
                        LOGGER.log(Level.INFO, "Insert successfully.");
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;

    }

}
