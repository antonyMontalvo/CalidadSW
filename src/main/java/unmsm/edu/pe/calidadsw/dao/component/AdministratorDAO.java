/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Usuario
 */
public class AdministratorDAO implements IAdministratorDAO {

    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("AdministratorDAO");

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
                    admin.setBirthdate(resultSet.getDate("birthdate"));
                }
                LOGGER.log(Level.INFO, "Admin.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return admin;
    }

}
