package unmsm.edu.pe.calidadsw.dao.component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import unmsm.edu.pe.calidadsw.dao.db.JDBCDataAccessClass;
import unmsm.edu.pe.calidadsw.dao.design.IPresentationDAO;
import unmsm.edu.pe.calidadsw.dao.model.Ambient;
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

public class PresentationDAO implements IPresentationDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger(PresentationDAO.class.getName());
    private static final String START_TIME = "presentation_start_time";

    public PresentationDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public List<Presentation> readExhibitorsEvent(Integer idevent) {
        /**
         * Lista de asistentes a un determinado evento
         */
        List<Presentation> presentations = new ArrayList<>();
        String sql = "{CALL sp_get_exhibitors_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, idevent);

            try (ResultSet resultSet = callableStatement.executeQuery();) {

                while (resultSet.next()) {
                    Presentation presentation = new Presentation();

                    if (resultSet.isFirst()) {
                        Event event = new Event();
                        event.setTitle(resultSet.getString("title"));
                        event.setDate(resultSet.getString("date"));
                        event.setDescription(resultSet.getString("description"));
                        event.setStartTime(resultSet.getInt("start_time"));
                        event.setEndTime(resultSet.getInt("end_time"));
                        event.setState(resultSet.getString("state"));

                        Ambient ambient = new Ambient();
                        ambient.setName(resultSet.getString("ambient_name"));
                        ambient.setDescription(resultSet.getString("ambient_description"));
                        ambient.setCapacity(resultSet.getInt("ambient_capacity"));

                        event.setAmbient(ambient);

                        presentation.setEvent(event);
                    }

                    presentation.setTheme(resultSet.getString("presentation_theme"));
                    presentation.setStartTime(resultSet.getInt(START_TIME));
                    presentation.setEndTime(resultSet.getInt("presentation_end_time"));

                    Exhibitor exhibitor = new Exhibitor();
                    exhibitor.setName(resultSet.getString("exhibitor_name"));
                    exhibitor.setLastname(resultSet.getString("exhibitor_last_name"));
                    exhibitor.setSpecialty(resultSet.getString("exhibitor_specialty"));

                    presentation.setExhibitor(exhibitor);

                    presentations.add(presentation);
                }
                LOGGER.log(Level.INFO, "Event info with presentations.");

            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return presentations;

    }

    @Override
    public boolean registerPresentation(Presentation presentation) {
        Boolean result = true;
        String sql = "{CALL sp_insert_exhibitors_event(?,?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, presentation.getStartTime());
            callableStatement.setInt(2, presentation.getEndTime());
            callableStatement.setString(3, presentation.getTheme());
            callableStatement.setInt(4, presentation.getEvent().getIdEvent());
            callableStatement.setInt(5, presentation.getExhibitor().getIdExhibitor());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 1) {
                        LOGGER.log(Level.INFO, "Exhibitor create succesfully.");
                    } else if (response == 0) {
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
    public HashMap<Integer, List<Presentation>> getAlgoritmo(List<Presentation> presentations) {
        HashMap<Integer, List<Presentation>> hashMap = new HashMap<>();
        String sql = "{CALL sp_filter_avaliable_exhibitors(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setString(1, presentations.get(0).getEvent().getDate());

            try (ResultSet resultSet = callableStatement.executeQuery();) {

                while (resultSet.next()) {

                    for (Presentation p : presentations) {
                        if (!hashMap.containsKey(p.getStartTime())) {
                            hashMap.put(p.getStartTime(), new ArrayList<Presentation>());
                        }

                        if (p.getStartTime() != resultSet.getInt(START_TIME)) {
                            Presentation presentation = new Presentation();

                            presentation.setTheme(resultSet.getString("presentation_theme"));
                            presentation.setStartTime(resultSet.getInt(START_TIME));
                            presentation.setEndTime(resultSet.getInt("presentation_end_time"));

                            Exhibitor exhibitor = new Exhibitor();
                            exhibitor.setName(resultSet.getString("exhibitor_name"));
                            exhibitor.setLastname(resultSet.getString("exhibitor_last_name"));
                            exhibitor.setSpecialty(resultSet.getString("exhibitor_specialty"));

                            presentation.setExhibitor(exhibitor);

                            hashMap.get(p.getStartTime()).add(presentation);
                        }

                    }

                }

                LOGGER.log(Level.INFO, "Exhibitors avaliables.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return hashMap;
    }

}
