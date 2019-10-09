package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IEventDAO;
import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;

public class EventDAO implements IEventDAO {

    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("EventDAO");

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public boolean create(Event event) {
        Boolean result = true;
        String sql = "{CALL sp_insert_event(?,?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, event.getTitle());
            callableStatement.setString(2, event.getDescription());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            callableStatement.setString(3, formatter.format(event.getDate()));
            callableStatement.setString(4, event.getState());
            callableStatement.setInt(5, event.getAmbient().getIdAmbient());
            callableStatement.setInt(6, event.getAdministrator().getIdAdministrator());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure create.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Event create succesfully.");
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
    public boolean delete(Integer id) {
        Boolean result = true;
        String sql = "{CALL sp_delete_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, id);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure delete.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Event delete succesfully.");
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
                ambient.setName(resultSet.getString("name_ambient"));
                event.setAmbient(ambient);
                administrator.setIdAdministrator(resultSet.getInt("idadministrator"));
                event.setAdministrator(administrator);

                events.add(event);
            }
            LOGGER.log(Level.INFO, "Events.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return events;
    }

    @Override
    public List<Event> search(String start_date, String end_date) {
        List<Event> events = new ArrayList<>();

        String sql = "{CALL sp_search_events(?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {
            callableStatement.setString(1, start_date);
            callableStatement.setString(2, end_date);
            ResultSet resultSet = callableStatement.executeQuery();

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
            LOGGER.log(Level.INFO, "Events.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }
        return events;
    }
    
    @Override
    public boolean publish(Integer id){
        Boolean result = true;
        String sql = "{CALL publish_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, id);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure publish.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Event published succesfully.");
                    }
                }
            }
        } catch (SQLException e) {
            result = false;
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;
    }
}
