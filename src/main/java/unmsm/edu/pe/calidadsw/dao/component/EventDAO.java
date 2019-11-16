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

public class EventDAO implements IEventDAO {

    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger(EventDAO.class.getName());
    private static final String RESPONSE = "response";
    private static final String IDAMBIENT = "idambient";
    private static final String IDEVENT = "idevent";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String DATE = "date";
    private static final String STATE = "state";

    public EventDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public int createBasic(Event event) {
        int result = 0;
        String sql = "{CALL sp_insert_event(?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, event.getTitle());
            callableStatement.setString(2, event.getDescription());
            callableStatement.setString(3, event.getDate());
            callableStatement.setInt(4, event.getAdministrator().getIdAdministrator());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt(RESPONSE);

                    if (response == 0) {
                        LOGGER.log(Level.WARNING, "Error to execute procedure create first part.");
                    } else {
                        result = response;
                        LOGGER.log(Level.INFO, "Event first part create succesfully.");
                    }
                }
            }
        } catch (SQLException e) {
            result = 0;
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return result;
    }

    // CAMBIAR
    @Override
    public boolean finalCreate(Event event, String cadHours) {
        Boolean result = false;
        String sql = "{CALL sp_update_event_ambient_final(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, event.getIdEvent());
            callableStatement.setInt(2, event.getAmbient().getIdAmbient());
            callableStatement.setInt(3, event.getStartTime());
            callableStatement.setInt(4, event.getEndTime());
            callableStatement.setString(5, cadHours);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt(RESPONSE);

                    if (response == 0) {
                        LOGGER.log(Level.WARNING, "Error to execute procedure create final part.");
                    } else if (response == 1) {
                        result = true;
                        LOGGER.log(Level.INFO, "Event final part create succesfully.");
                    }
                }
            }
        } catch (SQLException e) {
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
                    int response = resultSet.getInt(RESPONSE);

                    if (response == 1) {
                        LOGGER.log(Level.INFO, "Event delete succesfully.");
                    } else if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure delete.");
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

                event.setIdEvent(resultSet.getInt(IDEVENT));
                event.setTitle(resultSet.getString(TITLE));
                event.setDescription(resultSet.getString(DESCRIPTION));
                event.setDate(resultSet.getString(DATE));
                event.setState(resultSet.getString(STATE));

                if (resultSet.getInt(IDAMBIENT) != 0) {
                    ambient.setIdAmbient(resultSet.getInt(IDAMBIENT));
                    ambient.setName(resultSet.getString("name_ambient"));
                } else {
                    ambient.setName("Sin asignar");
                }
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
    public List<Event> search(String startDate, String endDate) {
        List<Event> events = new ArrayList<>();

        String sql = "{CALL sp_search_events(?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, startDate);
            callableStatement.setString(2, endDate);

            try (ResultSet resultSet = callableStatement.executeQuery();) {

                while (resultSet.next()) {
                    Event event = new Event();
                    Ambient ambient = new Ambient();
                    Administrator administrator = new Administrator();

                    event.setIdEvent(resultSet.getInt(IDEVENT));
                    event.setTitle(resultSet.getString(TITLE));
                    event.setDescription(resultSet.getString(DESCRIPTION));
                    event.setDate(resultSet.getString(DATE));
                    event.setState(resultSet.getString(STATE));

                    if (resultSet.getInt(IDAMBIENT) == 0) {
                        ambient.setName("Sin asignar");
                    } else {
                        ambient.setIdAmbient(resultSet.getInt(IDAMBIENT));
                        ambient.setName(resultSet.getString("name_ambient"));
                    }
                    event.setAmbient(ambient);

                    administrator.setIdAdministrator(resultSet.getInt("idadministrator"));
                    event.setAdministrator(administrator);

                    events.add(event);
                }
                LOGGER.log(Level.INFO, "Event found.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return events;
    }

    @Override
    public boolean publish(Integer id) {
        Boolean result = true;
        String sql = "{CALL publish_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, id);

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt(RESPONSE);

                    switch (response) {
                    case 0:
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure.");
                        break;
                    case 1:
                        LOGGER.log(Level.INFO, "Update successfully.");
                        break;
                    case 2:
                        result = false;
                        LOGGER.log(Level.WARNING, "The event selected not exits.");
                        break;
                    default:
                        break;
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
    public List<Event> filterSchedule(Event event) {
        List<Event> events = new ArrayList<>();

        String sql = "{CALL sp_filter_avaliable_hours(?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, event.getIdEvent());
            callableStatement.setInt(2, event.getAmbient().getIdAmbient());

            try (ResultSet resultSet = callableStatement.executeQuery();) {

                while (resultSet.next()) {
                    Event eventRes = new Event();
                    Ambient ambient = new Ambient();

                    eventRes.setIdEvent(resultSet.getInt(IDEVENT));
                    eventRes.setStartTime(resultSet.getInt("start_time"));
                    eventRes.setEndTime(resultSet.getInt("end_time"));

                    ambient.setIdAmbient(resultSet.getInt(IDAMBIENT));
                    eventRes.setAmbient(ambient);

                    events.add(eventRes);
                }
                LOGGER.log(Level.INFO, "Events schedules avalaible.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return events;
    }

}
