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
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;

public class EventDAO implements IEventDAO{
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("EventDAO");

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(Event t) {
        Boolean result = true;
        String sql = "{CALL sp_insert_event(?,?,?,?,?)}";

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

    @Override
    public boolean delete(Integer id) {
        Boolean result = true;
        String sql = "{CALL sp_delete_event(?)}";

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

    @Override
    public List<Event> read() {
        List<Event> events = new ArrayList<>();
        String sql = "{CALL sp_get_events()}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);
                ResultSet resultSet = callableStatement.executeQuery();) {

            while (resultSet.next()) {
                Event event = new Event();
                Ambient ambient = new Ambient();
                Administrator administrator = new Administrator();

                event.setIdEvent(resultSet.getInt("idevent"));
                event.setTitle(resultSet.getString("title"));
                event.setDescription(resultSet.getString("description"));
                event.setDate(resultSet.getDate("date"));
                event.setState(resultSet.getString("state"));

                ambient.setIdAmbient(resultSet.getInt("idambient"));
                event.setAmbient(ambient);

                administrator.setIdAdministrator(resultSet.getInt("idadministrator"));
                event.setAdministrator(administrator);

                events.add(event);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return events;
    }
}
