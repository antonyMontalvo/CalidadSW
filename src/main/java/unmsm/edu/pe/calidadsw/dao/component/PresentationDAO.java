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
import unmsm.edu.pe.calidadsw.dao.design.IPresentationDAO;
import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

public class PresentationDAO implements IPresentationDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("PresentationDAO");

    public PresentationDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    @Override
    public List<Exhibitor> readExhibitorsEvent(Event event) {
        /**
         * Lista de asistentes a un determinado evento
         */
        List<Exhibitor> exhibitors = new ArrayList<>();
        String sql = "{CALL sp_get_exhibitors_event(?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, event.getIdEvent());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Exhibitor exhibitor = new Exhibitor();

                    exhibitor.setDni(resultSet.getString("dni"));
                    exhibitor.setName(resultSet.getString("name"));
                    exhibitor.setLastname(resultSet.getString("lastname"));
                    exhibitor.setNationality(resultSet.getString("nationality"));
                    exhibitor.setSpecialty(resultSet.getString("specialty"));

                    exhibitors.add(exhibitor);
                }
                LOGGER.log(Level.INFO, "Presentations.");

            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return exhibitors;

    }

    @Override
    public boolean registerPresentation(Presentation presentation) {
        Boolean result = true;
        String sql = "{CALL sp_insert_exhibitors_event(?,?,?,?)}";

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            callableStatement.setInt(1, presentation.getStartTime());
            callableStatement.setInt(2, presentation.getEndTime());
            callableStatement.setInt(3, presentation.getExhibitor().getIdExhibitor());
            callableStatement.setInt(4, presentation.getEvent().getIdEvent());

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                if (resultSet.next()) {
                    int response = resultSet.getInt("response");

                    if (response == 0) {
                        result = false;
                        LOGGER.log(Level.WARNING, "Error to execute procedure create.");
                    } else if (response == 1) {
                        LOGGER.log(Level.INFO, "Exhibitor create succesfully.");
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
