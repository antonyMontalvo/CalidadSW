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
import unmsm.edu.pe.calidadsw.dao.model.Ambient;

public class AmbientDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("AmbientDAO");

    public AmbientDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Ambient t) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, t.getName());
            callableStatement.setString(2, t.getType());
            callableStatement.setString(3, t.getFloor());
            callableStatement.setInt(4, t.getCapacity());
            callableStatement.setString(5, t.getDescription());

            try (ResultSet resulSet = callableStatement.executeQuery();) {
                if (resulSet.next()) {
                    int response = resulSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.SEVERE, "Error to execute procedure create.");
                    }
                }
            }

        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    public boolean delete(Integer id) {
        Boolean result = true;
        String sql = "delete from ambient where idambient = " + id;

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, id);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.SEVERE, "Error to execute procedure delete.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    public List<Ambient> read() {
        List<Ambient> ambients = new ArrayList<>();
        String sql = "{CALL sp_get_ambients(?,?,?,?,?)}";

        try {
            try (Connection connection = jdbc.getJdbcConnection();
                    CallableStatement callableStatement = connection.prepareCall(sql);) {
                // ResultSet resultSet = statement.executesql("select " + "idambient" + ",name"
                // + ",type" + ",floor"
                // + ",capacity" + ",description" + " from ambient");

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
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return ambients;
    }
}
