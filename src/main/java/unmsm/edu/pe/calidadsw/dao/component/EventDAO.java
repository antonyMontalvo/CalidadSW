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
import unmsm.edu.pe.calidadsw.dao.model.Event;

public class EventDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("EventDAO");

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public boolean create(Event t) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // String query = "insert into event ("
        // // + "id_trabajador"
        // + "title" + ",description" + ",date" + ",state" + ",idambient" + ",dni) " +
        // "values ("
        // // + trabajador.getIdTrabajador()

        // + "'" + t.getTitle() + "'" + ",'" + t.getDescription() + "'" + ",'" +
        // String.valueOf(t.getDate())
        // + "'" + ",'" + t.getState() + "'" + ",'" + t.getIdAmbient() + "'" + ",'" +
        // t.getDni() + "')";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

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

    public boolean delete(Integer id) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // String query = "delete from event where idevent = " + id;

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure delete.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    public List<Event> read() {
        List<Event> events = new ArrayList<>();
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // ResultSet resultSet = statement.executeQuery("select " + "idevent" + ",title"
        // + ",description" + ",date"
        // + ",state" + ",idambient" + ",dni" + " from event");

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Event event = new Event();

                    event.setIdEvent(resultSet.getInt("idevent"));
                    event.setTitle(resultSet.getString("title"));
                    event.setDescription(resultSet.getString("description"));
                    event.setDate(resultSet.getString("date"));
                    event.setState(resultSet.getString("state"));
                    event.setIdAmbient(resultSet.getInt("idambient"));
                    event.setDni(resultSet.getInt("dni"));

                    events.add(event);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return events;
    }
}
