package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IAmbientDAO;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

public class AmbientDAO implements IAmbientDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger(AmbientDAO.class.getName());

    public AmbientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(Ambient ambient) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, ambient.getName());
            callableStatement.setString(2, ambient.getType());
            callableStatement.setString(3, ambient.getFloor());
            callableStatement.setInt(4, ambient.getCapacity());
            callableStatement.setString(5, ambient.getDescription());

            try (ResultSet resulSet = callableStatement.executeQuery();) {
                if (resulSet.next()) {
                    int response = resulSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.SEVERE, "Error to execute procedure create.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Ambient create succesfully.");
                    }
                }
            }

        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;
    }

    @Override
    public boolean delete(Integer idAmbient) {
        Boolean result = true;
        String sql = "{CALL sp_delete_ambient(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, idAmbient);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.SEVERE, "Error to execute procedure delete.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Ambient delete succesfully.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;
    }

    @Override
    public List<Ambient> read() {
        List<Ambient> ambients = new ArrayList<>();
        String sql = "{CALL sp_get_ambients()}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);
                ResultSet resultSet = callableStatement.executeQuery();) {

            while (resultSet.next()) {
                Ambient ambient = new Ambient();

                ambient.setIdAmbient(resultSet.getInt("idambient"));
                ambient.setName(resultSet.getString("name"));
                ambient.setType(resultSet.getString("type"));
                ambient.setFloor(resultSet.getString("floor"));
                ambient.setCapacity(resultSet.getInt("capacity"));
                ambient.setDescription(resultSet.getString("description"));

                ambients.add(ambient);
            }
            LOGGER.log(Level.INFO, "Ambients.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return ambients;
    }

    @Override
    public List<Ambient> filterAmbients(Integer idEvent) {
        List<Ambient> ambients = new ArrayList<>();
        String sql = "{CALL sp_get_ambients_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, idEvent);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Ambient ambient = new Ambient();

                    ambient.setIdAmbient(resultSet.getInt("idambient"));
                    ambient.setName(resultSet.getString("name"));
                    ambient.setType(resultSet.getString("type"));
                    ambient.setFloor(resultSet.getString("floor"));
                    ambient.setCapacity(resultSet.getInt("capacity"));
                    ambient.setDescription(resultSet.getString("description"));

                    ambients.add(ambient);
                }
                LOGGER.log(Level.INFO, "Event ambients.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return ambients;
    }
}
