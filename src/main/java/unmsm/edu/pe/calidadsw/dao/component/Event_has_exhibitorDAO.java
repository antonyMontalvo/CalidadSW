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
import unmsm.edu.pe.calidadsw.dao.model.Event_has_exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

public class Event_has_exhibitorDAO {
    private JDBCDataAccessClass jdbc;
    private static final Logger LOGGER = Logger.getLogger("Event_has_exhibitorDAO");
    
    public Event_has_exhibitorDAO() {
        jdbc = new JDBCDataAccessClass();
    }

    public List<Exhibitor> consultaTodosExpositoresEvento(Integer id) {
        // Lista de asistentes a un determinado evento
        List<Exhibitor> exhibitors = new ArrayList<>();
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // ResultSet resultSet = statement
        // .executeQuery("select " + " a.dni" + ",a.name" + ",a.lastname" +
        // ",a.nationality" + ",a.specialty"
        // + " from exhibitor a inner join event_has_assistant e on a.dni = e.dni where
        // e.idevent = "
        // + id + ";");

        try (Connection connection = jdbc.getJdbcConnection();
                CallableStatement callableStatement = connection.prepareCall(sql);) {

            try (ResultSet resultSet = callableStatement.executeQuery();) {
                while (resultSet.next()) {
                    Exhibitor exhibitor = new Exhibitor();

                    exhibitor.setDni(resultSet.getInt("dni"));
                    exhibitor.setName(resultSet.getString("name"));
                    exhibitor.setLastname(resultSet.getString("lastname"));
                    exhibitor.setNationality(resultSet.getString("nationality"));
                    exhibitor.setSpecialty(resultSet.getString("specialty"));

                    exhibitors.add(exhibitor);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return exhibitors;

    }

    public boolean inscribirExpositorEvento(Event_has_exhibitor event_has_exhibitor) {
        Boolean result = true;
        String sql = "{CALL sp_insert_ambient(?,?,?,?,?)}";
        // String query = "insert into event_has_exhibitor ("
        // // + "id_trabajador"
        // + "idevent" + ",dni) " + "values ("
        // // + trabajador.getIdTrabajador()
        // + "'" + event_has_exhibitor.getIdEvent() + "'" + ",'" +
        // event_has_exhibitor.getDni() + "')";

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

}
